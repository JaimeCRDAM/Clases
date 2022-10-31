using Avanzado.vcbTableAdapters;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Avanzado
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void peliculasBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.peliculasBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.vcb);

        }

        private void peliculasBindingNavigatorSaveItem_Click_1(object sender, EventArgs e)
        {
            this.Validate();
            this.peliculasBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.vcb);

        }

        private void peliculasBindingNavigatorSaveItem_Click_2(object sender, EventArgs e)
        {
            this.Validate();
            this.peliculasBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.vcb);

        }

        private void peliculasBindingNavigatorSaveItem_Click_3(object sender, EventArgs e)
        {
            this.Validate();
            this.peliculasBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.vcb);

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'vcb.peliculas' Puede moverla o quitarla según sea necesario.
            this.peliculasTableAdapter.Fill(this.vcb.peliculas);
            categoriasTableAdapter categorias = new categoriasTableAdapter();
            var ak = categorias.GetDataCategoria().Rows;
            foreach (var row in ak)
            {
               var lol = row.;
            }
            Console.WriteLine("s");
            //categoriaComboBox.Items.AddRange();

        }

        private void anioLabel1_Click(object sender, EventArgs e)
        {

        }

        private void anioLabel_Click(object sender, EventArgs e)
        {

        }

        private void tituloTextBox_TextChanged(object sender, EventArgs e)
        {

        }

        private void caratulaLabel_Click(object sender, EventArgs e)
        {

        }

        private void peliculasBindingNavigator_RefreshItems(object sender, EventArgs e)
        {

        }
    }
}
