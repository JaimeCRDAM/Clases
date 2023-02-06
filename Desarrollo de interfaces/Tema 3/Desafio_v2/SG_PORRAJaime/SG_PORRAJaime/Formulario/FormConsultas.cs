using SG_PORRAJaime.Administrar_carpeta;
using SG_PORRAJaime.DB;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SG_PORRAJaime.Formulario
{
    public partial class FormConsultas : Form
    {
        public FormConsultas()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            using (bd_porraEntities db = new bd_porraEntities())
            {
                var usuarios = db.APUESTAS.Select(x => x).GroupBy(x => x.Usuario).OrderBy(x => x.Count()).FirstOrDefault();
                var cantidad = usuarios.Count();
                var id = usuarios.Key;
                var usuario = db.USUARIOS.Where(x => x.Id_usuario == id).Select(x => new { x.Dni, x.Email, cantidad }).ToList();
                dataGridView1.DataSource = usuario;
                foreach (DataGridViewColumn item in dataGridView1.Columns)
                {
                    item.AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill;
                }
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {

        }
    }
}
