using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Videoclub
{
    public partial class clientes : Form
    {
        public clientes()
        {
            InitializeComponent();
        }

        private void clientes_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'vBDS.socios' Puede moverla o quitarla según sea necesario.
            this.sociosTableAdapter.Fill(this.vBDS.socios);

        }

        private void BTNGuardar_Click(object sender, EventArgs e)
        {
            this.sociosTableAdapter.Update(this.vBDS.socios);
        }
    }
}
