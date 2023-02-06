using SG_PORRAJaime.bd_porraDataSetTableAdapters;
using SG_PORRAJaime.utils;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SG_PORRAJaime.Partidos_carpeta
{
    public partial class Nuevo : Form
    {
        int localIndex = -1;
        int visitanteIndex = -1;
        public Nuevo()
        {
            InitializeComponent();
            var items = getData().ToArray();
            CBLocal.Items.AddRange(items);
            CBLocal.SelectedIndex = 0;
            CBVisitante.Items.AddRange(items);
            CBLocal.SelectedIndex = 1;

        }

        private void eQUIPOSBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.eQUIPOSBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.bd_porraDataSet);

        }

        private void eQUIPOSBindingNavigatorSaveItem_Click_1(object sender, EventArgs e)
        {
            this.Validate();
            this.eQUIPOSBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.bd_porraDataSet);

        }

        private void Nuevo_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'bd_porraDataSet.PARTIDOS' Puede moverla o quitarla según sea necesario.
            this.pARTIDOSTableAdapter.Fill(this.bd_porraDataSet.PARTIDOS);
            // TODO: esta línea de código carga datos en la tabla 'bd_porraDataSet.EQUIPOS' Puede moverla o quitarla según sea necesario.
            this.eQUIPOSTableAdapter.Fill(this.bd_porraDataSet.EQUIPOS);

        }

        private void CBLocal_SelectedIndexChanged(object sender, EventArgs e)
        {
            if( CBLocal.SelectedIndex == CBVisitante.SelectedIndex ) {
                MessageBox.Show("No se pueden enfrentar el mismo equipo");
            }
        }

        private List<ComboItem> getData()
        {
            var lista = new List<ComboItem>();
            EQUIPOSTableAdapter equipos = new EQUIPOSTableAdapter();
            foreach (var item in equipos.GetData())
            {
                var comboItem = new ComboItem();
                comboItem.Value = item.Id_equipo;
                comboItem.Text = item.Nombre;
                lista.Add(comboItem);

            }
            return lista;
        }

        private void CBVisitante_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (CBLocal.SelectedIndex == CBVisitante.SelectedIndex)
            {
                MessageBox.Show("No se pueden enfrentar el mismo equipo");
                CBVisitante.SelectedIndex = visitanteIndex;
            }
        }

        private void BTNCrear_Click(object sender, EventArgs e)
        {
            PARTIDOSTableAdapter partidos = new PARTIDOSTableAdapter();
            var hora = NHora.Value.ToString()+":"+ NumericMinuto.Value.ToString();
            partidos.InsertarPartido(DTPFecha.Value.ToString("yyyy-MM-dd"), hora, (int)((ComboItem)CBLocal.SelectedItem).Value, (int)((ComboItem)CBVisitante.SelectedItem).Value);
            this.tableAdapterManager.UpdateAll(this.bd_porraDataSet);
        }

        private void DTPFecha_ValueChanged(object sender, EventArgs e)
        {
            if (DTPFecha.Value < DateTime.Today){
                MessageBox.Show("No puedes seleccionar una fecha menor a la de hoy");
                DTPFecha.Value = DateTime.Today;
            }
        }
    }
}
