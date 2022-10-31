using Plantillas.Forms;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PlantillasV2.Forms
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        Form cuadro;
        Form triangulo;
        Form colores;
        Form listas;
        Form cajas;
        Form comboBox;
        Form calendario;
        Form temporizador;
        Form gamaColores;
        Form listaImagenes;


        private void BTNTextBox_Click(object sender, EventArgs e)
        {
            if(cuadro == null)
            {
                cuadro = new CuadroTexto();
                CambiarMdiHijo<Form>(cuadro);
                return;
            }
            CambiarMdiHijo<Form>(cuadro);

        }

        private void BTNTriangulos_Click(object sender, EventArgs e)
        {
            if (triangulo == null)
            {
                triangulo = new Triangulos();
                CambiarMdiHijo<Form>(triangulo);
                return;
            }
            CambiarMdiHijo<Form>(triangulo);
        }

        private void BTNColores_Click(object sender, EventArgs e)
        {
            if (colores == null)
            {
                colores = new Colores();
                CambiarMdiHijo<Form>(colores);
                return;
            }
            CambiarMdiHijo<Form>(colores);
        }

        private void BTNListas_Click(object sender, EventArgs e)
        {

        }

        private void BTNCajas_Click(object sender, EventArgs e)
        {
            if (cajas == null)
            {
                cajas = new Cajas();
                CambiarMdiHijo<Form>(cajas);
                return;
            }
            CambiarMdiHijo<Form>(cajas);
        }

        private void BTNComboBox_Click(object sender, EventArgs e)
        {

        }

        private void BTNCalendario_Click(object sender, EventArgs e)
        {
            if (calendario == null)
            {
                calendario = new Calendario();
                CambiarMdiHijo<Form>(calendario);
                return;
            }
            CambiarMdiHijo<Form>(calendario);
        }

        private void BTNTemporizador_Click(object sender, EventArgs e)
        {

        }

        private void BTNGamaColores_Click(object sender, EventArgs e)
        {

        }

        private void BTNListaImagen_Click(object sender, EventArgs e)
        {

        }
        private void CambiarMdiHijo<T>(T form) where T : Form
        {
            form.MdiParent = this;
            form.PerformAutoScale();
            form.Show();
            form.WindowState = FormWindowState.Maximized;
        }
    }
}
