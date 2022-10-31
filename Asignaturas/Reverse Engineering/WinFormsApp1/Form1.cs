using Microsoft.VisualBasic;
using System.Data;
using System.DirectoryServices;
using System.Windows.Forms;
using System.Xml;

namespace WinFormsApp1
{
    public partial class Form1 : Form
    {
        DataSet dataSet;

        public Form1()
        {

            InitializeComponent();
            dataSet = new("Horario");
            dataSet.Tables.Add(new DataTable("horas"));
            dataSet.Tables[0].Columns.Add("Hora", typeof(string));
            for (int i = 1; i < 6; i++)
            {
                dataSet.Tables[0].Columns.Add(DateAndTime.WeekdayName(i), typeof(string));
            }
            foreach ( string item in CBHora.Items)
            {
                dataSet.Tables[0].Rows.Add(item);
            }
            DGVHorario.DataSource = dataSet.Tables[0];
        }

        private void BTNCargar_Click(object sender, EventArgs e)
        {
            XmlDocument xDoc;
            DataSet dataSet = new DataSet();

            //Se lee el XML con un XMLDocument
            xDoc = new XmlDocument();
            xDoc.Load("Horario_2DAM.xml");
            //Añadimos la tabla al horario directamente, con las columnas fijas
            dataSet.Tables.Add(new DataTable("horario"));
            dataSet.Tables[0].Columns.Add("Hora", typeof(string));
            for (int i = 1; i < 6; i++)
            {
                dataSet.Tables[0].Columns.Add(DateAndTime.WeekdayName(i), typeof(string));
            }

            //Recorremos el XMLDocument y vamos rellenando el DataSet junto con los tooltiptext
            XmlNodeList horario = xDoc.GetElementsByTagName("horario");
            XmlNodeList horas = ((XmlElement)horario[0]).GetElementsByTagName("hora");
            int cont_hora = 0;
            foreach (XmlElement hora in horas)
            {
                //Construimos dos arrays de strings, uno para los textos a mostrar y otros con las ayudas
                string[] fila_pant = new string[6];
                string[] fila_ayu = new string[6];

                //La primera columna de cada fila será la hora: primera, segunda, etc.
                fila_pant[0] = hora.GetAttribute("id").ToString();
                fila_ayu[0] = "";
                int col = 1;
                XmlNodeList dias = hora.GetElementsByTagName("dia");
                foreach (XmlElement dia in dias)
                {
                    XmlNodeList entrada_pant = dia.GetElementsByTagName("pantalla");
                    fila_pant[col] = ((XmlElement)entrada_pant[0]).InnerText.ToString();
                    XmlNodeList entrada_ayu = dia.GetElementsByTagName("ayuda");
                    fila_ayu[col] = ((XmlElement)entrada_ayu[0]).InnerText.ToString();
                    col++;
                }
                dataSet.Tables[0].Rows.Add(fila_pant);
                //Antes de pasar a la siguiente fila, se enlaza el dataGridView y el DataSet
                //Y así podemos establecer los textos de ayuda
                DGVHorario.DataSource = dataSet.Tables[0];
                for (int c = 1; c < fila_ayu.Length; c++)
                {
                    DGVHorario.Rows[cont_hora].Cells[c].ToolTipText = fila_ayu[c];
                }
                cont_hora++;
            }

        }

        private void CBHora_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void BTNAnadir_Click(object sender, EventArgs e)
        {
            int horaIndex = CBHora.SelectedIndex;
            int diaIndex = CBDia.SelectedIndex;
            string modulo = LVModulos.SelectedItems[0].Text;
            DGVHorario.Rows[horaIndex].Cells[diaIndex+1].Value = modulo;
        }

        private void BTNGuardar_Click(object sender, EventArgs e)
        {
            XmlDocument xDoc = new XmlDocument();
            xDoc.LoadXml(dataSet.GetXml());
            xDoc.Save("ak.xml");
        }
    }
}