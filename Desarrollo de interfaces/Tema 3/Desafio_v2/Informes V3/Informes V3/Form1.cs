using Informes_Ertes_V3;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Informes_V3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            this.dataTable1TableAdapter.FillBy(this.bd_ertesDataSet.DataTable1, ((ComboItem)comboBox1.SelectedItem).Text);
            this.reportViewer1.RefreshReport();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'bd_ertesDataSet.DataTable1' Puede moverla o quitarla según sea necesario.
            this.dataTable1TableAdapter.Fill(this.bd_ertesDataSet.DataTable1);
            // TODO: esta línea de código carga datos en la tabla 'bd_ertesDataSet.DataTable1' Puede moverla o quitarla según sea necesario.
            this.dataTable1TableAdapter.Fill(this.bd_ertesDataSet.DataTable1);
            var sectores = new bd_ertesDataSetTableAdapters.SECTORESTableAdapter().GetData().OrderBy(x => x.Descripcion);
            sectores.ToList().ForEach(s => comboBox1.Items.Add(new ComboItem { Text = s.Descripcion, Value = s.Id_sector }));
            this.reportViewer1.RefreshReport();
            this.reportViewer1.RefreshReport();
        }

        private void TBAño_TextChanged(object sender, EventArgs e)
        {
            this.dataTable1TableAdapter.FillByNombre(this.bd_ertesDataSet.DataTable1, TBAño.Text + "%");
            this.reportViewer1.RefreshReport();
        }
    }
}
