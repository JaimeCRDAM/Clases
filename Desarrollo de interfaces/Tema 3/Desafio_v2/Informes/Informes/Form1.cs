using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Informes
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'videoclubDataSet.socios' Puede moverla o quitarla según sea necesario.
            this.sociosTableAdapter.Fill(this.videoclubDataSet.socios);
            // TODO: esta línea de código carga datos en la tabla 'videoclubDataSet.peliculas' Puede moverla o quitarla según sea necesario.
            this.peliculasTableAdapter.Fill(this.videoclubDataSet.peliculas);

            this.reportViewer1.RefreshReport();
        }

        private void TBAño_TextChanged(object sender, EventArgs e)
        {
            var ak = Convert.ToInt32(TBAño.Text.ToString());
            this.peliculasTableAdapter.FillBy(this.videoclubDataSet.peliculas, ak);
            this.reportViewer1.RefreshReport();
        }
    }
}
