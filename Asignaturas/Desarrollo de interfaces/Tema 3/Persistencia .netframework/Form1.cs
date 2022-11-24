using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Persistencia.netframework
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void BTNInsert_Click(object sender, EventArgs e)
        {
            using (videoclubBinario2Entities db = new videoclubBinario2Entities())
            {
                categorias categorias = new categorias();
                categorias.categoria = TBCategoria.Text;
                categorias.precio = (decimal?)float.Parse(TBPrecio.Text);

                db.categorias.Add(categorias);

                db.SaveChangesAsync();
                MessageBox.Show("Categoria guardada correctamente");
            }
        }

        private void BTNUpdate_Click(object sender, EventArgs e)
        {
            using (videoclubBinario2Entities db = new videoclubBinario2Entities())
            {
                categorias categoria;
                categoria = db.categorias.Find(TBCategoria.Text);
                if (categoria == null)
                {
                    MessageBox.Show("No se pudo actualizar");
                    return;
                }

                categoria.precio = (decimal?)float.Parse(TBPrecio.Text);

                db.SaveChanges();

                MessageBox.Show("Categoria guardada correctamente");
            }
        }

        private void BTNDelete_Click(object sender, EventArgs e)
        {
            {
                using (videoclubBinario2Entities db = new videoclubBinario2Entities())
                {
                    categorias categoria;
                    categoria = db.categorias.Find(TBCategoria.Text);
                    if (categoria == null)
                    {
                        MessageBox.Show("No se pudo borrar");
                        return;
                    }

                    db.categorias.Remove(categoria);

                    db.SaveChanges();

                    MessageBox.Show("Categoria borrada correctamente");
                }
            }
        }

        private void BTNCambiarForm_Click(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            using(videoclubBinario2Entities db = new videoclubBinario2Entities())
            {
                decimal precio = Decimal.Parse(TBPrecioLINQ.Text);
                var cat = (from categoria in db.categorias where categoria.precio >= precio select new { categoria.categoria, categoria.precio }).ToList();
                dataGridView1.DataSource = cat;
            }
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {
            using (videoclubBinario2Entities db = new videoclubBinario2Entities())
            {

                var peli = (from pelicula in db.peliculas
                            from categoria in db.categorias
                            where categoria.categoria == pelicula.categoria && categoria.categoria.ToLower().StartsWith(textBox2.Text.ToLower())
                            select new { pelicula.titulo, pelicula.anio, pelicula.estilo, categoria.precio }).ToList();
                dataGridView2.DataSource = peli;
            }
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void TBCategoria_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
