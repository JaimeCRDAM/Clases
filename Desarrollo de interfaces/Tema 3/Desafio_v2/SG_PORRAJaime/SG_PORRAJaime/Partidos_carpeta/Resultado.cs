using SG_PORRAJaime.DB;
using SG_PORRAJaime.utils;
using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SG_PORRAJaime.Partidos_carpeta
{
    public partial class Resultado : Form
    {
        List<string> lista;
        String valor = "";
        public Resultado(List<string> lista)
        {
            InitializeComponent();
            textBox1.Text = lista[0];
            textBox4.Text = lista[1];
            textBox3.Text = lista[2];
            textBox2.Text = lista[3];
            this.lista = lista;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            using (bd_porraEntities db = new bd_porraEntities())
            {
                var nombreLocal = lista[0];
                var idLocal = db.EQUIPOS.Where(x => x.Nombre == nombreLocal).Select(x => x.Id_equipo).ToList()[0];
                var nombreVisita = lista[1];
                var idVisita = db.EQUIPOS.Where(x => x.Nombre == nombreVisita).Select(x => x.Id_equipo).ToList()[0];
                var fecha =  DateTime.Parse(lista[2]);
                var partido = db.PARTIDOS.Where(x => x.Equipo_local == idLocal && x.Equipo_visitante == idVisita && x.Fecha == fecha).Select(x => x).ToList()[0];
                partido.Resultado = valor;
            }
        }

        private void RB1_CheckedChanged(object sender, EventArgs e)
        {
            valor = "1";
        }

        private void RBX_CheckedChanged(object sender, EventArgs e)
        {
            valor = "X";
        }

        private void RB2_CheckedChanged(object sender, EventArgs e)
        {
            valor = "2";
        }
    }
}
