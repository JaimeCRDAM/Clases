using SG_PORRAJaime.DB;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SG_PORRAJaime.Administrar_carpeta
{
    public partial class AñadirUsuario : Form
    {
        public AñadirUsuario()
        {
            InitializeComponent();
        }

        public AñadirUsuario(USUARIOS usuario)
        {
            InitializeComponent();
            TBCif.Text = usuario.Dni;
            TBDomicilio.Text = usuario.Domicilio;
            TBEmail.Text = usuario.Email;
            TBCodigoPostal.Text = usuario.CPostal;
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void BTNAceptar_Click(object sender, EventArgs e)
        {
            var usuario = new USUARIOS();
            if (!string.IsNullOrEmpty(TBCif.Text))
            {
                usuario.Dni = TBCif.Text.ToString();
            }
            if (!string.IsNullOrEmpty(TBEmail.Text))
            {
                var expresion = @"\A(\w+\.?\w*\@\w+\.)(com)\Z";
                if(Regex.Match(TBEmail.Text.ToString(), expresion) != null)
                {
                    usuario.Email = TBEmail.Text.ToString();
                }
                else
                {
                    MessageBox.Show("Porfavor indique un email valido");
                }
            }
            if (!string.IsNullOrEmpty(TBDomicilio.Text))
            {
                usuario.Domicilio = TBDomicilio.Text.ToString();
            }
            if (!string.IsNullOrEmpty(TBCodigoPostal.Text))
            {
                var expresion = @"\A^(?:0[1-9]|[1-4]\d|5[0-2])\d{3}$\Z";
                if (Regex.Match(TBCodigoPostal.Text.ToString(), expresion) != null)
                {
                    usuario.CPostal = TBCodigoPostal.Text.ToString();
                }
                else
                {
                    MessageBox.Show("Porfavor indique un codigo postal valido");
                }
            }
            using (bd_porraEntities db = new bd_porraEntities())
            {
                var isCifTaken = db.USUARIOS.Select(x => x.Dni).Where(x => x == usuario.Dni).Any();
                if (!isCifTaken)
                {
                    db.USUARIOS.Add(usuario);
                    db.SaveChanges();
                    this.Close();
                    return;
                }
                MessageBox.Show("Ya existe una persona con ese DNI");
            }
        }

        private void BTNVolver_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
