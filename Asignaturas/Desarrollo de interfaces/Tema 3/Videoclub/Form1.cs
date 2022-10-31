using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Videoclub.VBDSTableAdapters;

namespace Videoclub
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void BTNAceptar_Click(object sender, EventArgs e)
        {
            VBDS vBDS = new VBDS();
            sociosTableAdapter adapter = new sociosTableAdapter();
            adapter.GetDataByLogin(TBLogin.Text, TBPassword.Text);
            adapter.FillByLogin(vBDS.socios, TBLogin.Text, TBPassword.Text);

            if(vBDS.socios.Count > 0)
            {
                MessageBox.Show(vBDS.socios[0].nombre, "tusmuertos", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            {
                MessageBox.Show("Te has equivocado de cosis");
            }
        }
    }
}
