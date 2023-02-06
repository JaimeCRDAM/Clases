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

namespace SG_PORRAJaime.Administrar_carpeta
{
    public partial class Usuarios : Form
    {
        public Usuarios()
        {
            InitializeComponent();
            RefreshDGV();
        }

        private void DGVUsuarios_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void RefreshDGV()
        {
            using (bd_porraEntities db = new bd_porraEntities())
            {
                var usuarios = db.USUARIOS.Select(x => new { x.Email, x.Dni, x.CPostal }).OrderBy( x => x.Email).ToList();
                DGVUsuarios.DataSource = usuarios;
                foreach (DataGridViewColumn item in DGVUsuarios.Columns)
                {
                    item.AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill;
                }
            }
        }

        private void BTNAñadir_Click(object sender, EventArgs e)
        {
            Form modEmpresas = new AñadirUsuario();
            modEmpresas.ShowDialog();
            RefreshDGV();
        }

        private void BTNModificar_Click(object sender, EventArgs e)
        {
            if (DGVUsuarios.SelectedRows == null)
            {
                MessageBox.Show("Selecciona una fila antes de intentar modificarla");
                return;
            }
            using (bd_porraEntities db = new bd_porraEntities())
            {
                var usuarioDni = DGVUsuarios.SelectedRows[0].Cells[1].Value.ToString();
                var usuario = db.USUARIOS.Select(x => x).Where(x => x.Dni == usuarioDni).ToList();
                Form modUsuarios = new AñadirUsuario(usuario[0]);
                modUsuarios.ShowDialog();
                RefreshDGV();
            }
        }

        private void BTNEliminar_Click(object sender, EventArgs e)
        {
            if (DGVUsuarios.SelectedRows == null)
            {
                MessageBox.Show("Selecciona una fila antes de intentar eliminar");
                return;
            }
            using (bd_porraEntities db = new bd_porraEntities())
            {


                var usuarioDni = DGVUsuarios.SelectedRows[0].Cells[1].Value.ToString();
                var usuario = db.USUARIOS.Select(x => x).Where(x => x.Dni == usuarioDni).ToList()[0];
                DialogResult eliminar = MessageBox.Show("Desea eliminar el usuario seleccionado?", "Confirmacion", MessageBoxButtons.YesNo, MessageBoxIcon.Question);

                if (eliminar == DialogResult.Yes)
                {
                    var usuarioid = db.USUARIOS.Where(x => x.Dni == usuarioDni).Select(x => x.Id_usuario).ToList()[0];
                    var apuestas = db.APUESTAS.Where(x => x.Usuario == usuarioid).Select(x => x).ToList();
                    if(apuestas.Count > 0)
                    {
                        MessageBox.Show("Este usuario tiene apuestas pendientes");
                        return;
                    }
                    db.USUARIOS.Remove(usuario);
                    db.SaveChanges();
                    RefreshDGV();
                }
            }
        }

        private void DGVUsuarios_CellContentDoubleClick(object sender, DataGridViewCellEventArgs e)
        {
            using (bd_porraEntities db = new bd_porraEntities())
            {
                var usuarioDni = DGVUsuarios.SelectedRows[0].Cells[1].Value.ToString();
                var usuario = db.USUARIOS.Select(x => x).Where(x => x.Dni == usuarioDni).ToList();
                Form modUsuarios = new AñadirUsuario(usuario[0]);
                modUsuarios.ShowDialog();
                RefreshDGV();
            }
        }
    }
}
