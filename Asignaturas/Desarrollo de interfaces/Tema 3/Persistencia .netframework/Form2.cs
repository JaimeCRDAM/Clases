using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Windows.Forms.VisualStyles;

namespace Persistencia.netframework
{
    public partial class Form2 : Form
    {
        public Form2()
        {

            InitializeComponent();
            using (videoclubBinario2Entities db = new videoclubBinario2Entities())
            {
                var categorias = db.categorias.Select(x => x.categoria).ToArray();
                CBCategoria.Items.AddRange(categorias);
                var estilos = db.estilos.Select(x => x.estilo).ToArray();
                CBEstilo.Items.AddRange(estilos);
            }
        }

        private void CBEstilo_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            using (videoclubBinario2Entities db = new videoclubBinario2Entities())
            {
                var sql = (
                    from pelicula in db.peliculas
                    from alquileres in db.alquileres
                    from socios in db.socios
                    where pelicula.codpeli == alquileres.codAlquiler && socios.idSocio == alquileres.socio
                    orderby alquileres.fechaAlquiler descending
                    select new
                    {
                        pelicula.titulo,
                        pelicula.anio,
                        pelicula.director,
                        pelicula.estilo,
                        pelicula.categoria,
                        alquileres.fechaAlquiler,
                        socios.apell1,
                        socios.nombre
                    }
                    );

                if(!(TBAnio.Text == ""))
                {
                    var anio = Int32.Parse(TBAnio.Text);
                    sql = sql.Where(x => x.anio == anio);
                }

                dataGridView1.DataSource = sql.ToList();
            }
        }
    }
}
