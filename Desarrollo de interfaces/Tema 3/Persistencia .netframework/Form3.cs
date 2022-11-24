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
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            using(videoclubBinario2Entities db = new videoclubBinario2Entities())
            {
                var socios = db.alquileres.Select(x => x.socios.idSocio).ToList();
                var nombres = db.socios.Where(x => socios.Contains(x.idSocio)).Select(x => new { x.nombre, x.apell1, x.apell2 }).ToList();
                dataGridView1.DataSource = nombres;
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            dataGridView1.DataSource = null;
            using (videoclubBinario2Entities db = new videoclubBinario2Entities())
            {
                var socios = db.alquileres.Where(x => x.fechaDevolucion == null).Select(x => x.socios.idSocio).ToList();
                var nombres = db.socios.Where(x => socios.Contains(x.idSocio)).Select(x => new { x.nombre, x.apell1, x.apell2 }).ToList();
                dataGridView1.DataSource = nombres;
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            dataGridView1.DataSource = null;
            using (videoclubBinario2Entities db = new videoclubBinario2Entities())
            {
                var socios = db.alquileres.Select(x => x.socios.idSocio).ToList();
                var nombres = db.socios.Where(x => !socios.Contains(x.idSocio)).Select(x => new { x.nombre, x.apell1, x.apell2 }).ToList();
                dataGridView1.DataSource = nombres;
            }
        }


        private void button4_Click(object sender, EventArgs e)
        {
            dataGridView1.DataSource = null;
            using (videoclubBinario2Entities db = new videoclubBinario2Entities())
            {
                var socios = db.alquileres.GroupBy(x => x.socios.idSocio).Where(x => x.Count() >= 2).Select(x => x.Key).ToList();
                var nombres = db.socios.Where(x => socios.Contains(x.idSocio)).Select(x => new { x.nombre, x.apell1, x.apell2}).ToList();
                dataGridView1.DataSource = nombres;
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            dataGridView1.DataSource = null;
            using (videoclubBinario2Entities db = new videoclubBinario2Entities())
            {
                var max = db.alquileres.GroupBy(x => x.pelicula).Max(x => x.Key);
                var idPelicula = db.alquileres.Select(x => x).GroupBy(x => x.pelicula).Where(x => x.Key == max).ToList();
                var peliInfo = db.peliculas.Where(x => x.codpeli == idPelicula.Count).Select(x => new { x.titulo }).ToList();
                dataGridView1.DataSource = peliInfo;
            }
        }

        private void button6_Click(object sender, EventArgs e)
        {
            dataGridView1.DataSource = null;
            using (videoclubBinario2Entities db = new videoclubBinario2Entities())
            {
                var max = db.peliculas.GroupBy(x => x.estilo).Max(x => x.Key);
                var estilo = db.estilos.Where(x => x.estilo == max).Select(x => new { x.estilo }).ToList();
                dataGridView1.DataSource = estilo;

            }
        }

        private void button7_Click(object sender, EventArgs e)
        {
            dataGridView1.DataSource = null;
            using (videoclubBinario2Entities db = new videoclubBinario2Entities())
            {
                var oldestMovie = db.peliculas.OrderByDescending(x => x.anio).Select(x => x.codpeli).First();
                var oldestStyle = db.peliculas.Where(x => x.codpeli == oldestMovie).Select(x => new { x.estilo, x.categoria }).ToList();

                dataGridView1.DataSource = oldestStyle;

            }
        }

        private void button8_Click(object sender, EventArgs e)
        {
            dataGridView1.DataSource = null;
            using (videoclubBinario2Entities db = new videoclubBinario2Entities())
            {
                var average = db.alquileres.GroupBy(x => x.pelicula).Average(x => x.Key);
                var idSocios = db.alquileres.Select(x => x).GroupBy(x => x.socio).Where(x => x.Key >= average).ToList();
                var peliInfo = db.socios.Where(x => x.idSocio == idSocios.Count).Select(x => new { x.nombre }).ToList();
                dataGridView1.DataSource = peliInfo;
            }

        }
    }
}
