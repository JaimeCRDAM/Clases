using SG_PORRAJaime.Administrar_carpeta;
using SG_PORRAJaime.Formulario;
using SG_PORRAJaime.Partidos_carpeta;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SG_PORRAJaime
{
    public partial class Principal : Form
    {
        Form currentForm;
        public Principal()
        {
            InitializeComponent();
        }

        private void salirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void CambiarMdiHijo<T>(T form) where T : Form
        {
            Form oldForm = currentForm;
            if (oldForm != null)
            {
                this.MdiChildren[0].Close();
            }

            currentForm = form;
            currentForm.MdiParent = this; //802, 452
            currentForm.Dock = DockStyle.Fill;
            Size = new Size(currentForm.Width, currentForm.Height + 24);
            form.Show();

        }
        private void MenuCambiar(Form form)
        {
            Form futureForm = form;
            if (currentForm == null)
            {
                CambiarMdiHijo<Form>(futureForm);
                return;
            }
            if (currentForm.GetType() != futureForm.GetType())
            {
                DialogResult eliminar = MessageBox.Show("Desea Cerrar el formulario actual?", "Confirmacion", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
                if (eliminar == DialogResult.Yes)
                {
                    CambiarMdiHijo<Form>(futureForm);
                }
            }
        }

        private void usuariosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MenuCambiar(new Usuarios());
        }

        private void equiposToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MenuCambiar(new Equipos());
        }

        private void nuevoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MenuCambiar(new Nuevo());
        }

        private void listaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MenuCambiar(new Lista());
        }

        private void iNFORMESToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MenuCambiar(new FormConsultas());
        }
    }
}
