using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Plantillas.Forms
{
    public partial class Colores : Form
    {
        public Colores()
        {
            InitializeComponent();
        }

        private void BTNLetra_Click(object sender, EventArgs e)
        {
            FontDialog fontD = new FontDialog();
            fontD.ShowDialog();
            TEXTBColoresLetra.Font = fontD.Font;
        }

        private void BTNColor_Click(object sender, EventArgs e)
        {
            ColorDialog colorD = new ColorDialog();
            colorD.ShowDialog();
            TEXTBColoresLetra.ForeColor = colorD.Color;
        }
    }
}
