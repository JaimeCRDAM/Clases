using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Informes_Ertes
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'bd_ertesDataSet.DataTable1' Puede moverla o quitarla según sea necesario.
            this.dataTable1TableAdapter.Fill(this.bd_ertesDataSet.DataTable1);
            // TODO: esta línea de código carga datos en la tabla 'bd_ertesDataSet.EMPRESAS' Puede moverla o quitarla según sea necesario.
            this.eMPRESASTableAdapter.Fill(this.bd_ertesDataSet.EMPRESAS);
            // TODO: esta línea de código carga datos en la tabla 'bd_ertesDataSet.EMPLEADOS' Puede moverla o quitarla según sea necesario.
            this.eMPLEADOSTableAdapter.Fill(this.bd_ertesDataSet.EMPLEADOS);

            this.reportViewer1.RefreshReport();
        }
    }
}
