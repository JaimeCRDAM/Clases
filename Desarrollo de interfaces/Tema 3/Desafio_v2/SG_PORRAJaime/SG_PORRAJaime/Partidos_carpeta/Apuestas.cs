using SG_PORRAJaime.bd_porraDataSetTableAdapters;
using SG_PORRAJaime.DB;
using SG_PORRAJaime.utils;
using System;
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
    public partial class Apuestas : Form
    {
        List<string> lista;
        string valor = "";
        public Apuestas(List<string> lista)
        {
            InitializeComponent();
            textBox1.Text = lista[0];
            textBox4.Text = lista[1];
            textBox3.Text = lista[2];
            textBox2.Text = lista[3];
            CBUsuarios.Items.AddRange(getData().ToArray());
            this.lista = lista;
        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }
        private List<ComboItem> getData()
        {
            var lista = new List<ComboItem>();
            using (bd_porraEntities db = new bd_porraEntities())
            {
                var usuarios = db.USUARIOS.Select(x => new { x.Email, x.Id_usuario }).OrderBy(x => x.Email).ToList();
                foreach (var item in usuarios)
                {
                    var comboItem = new ComboItem();
                    comboItem.Value = item.Id_usuario;
                    comboItem.Text = item.Email;
                    lista.Add(comboItem);
                }
            }
            return lista;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            var partido = getPartido();
            var idpartido = partido.Id_partido;
            using (bd_porraEntities db = new bd_porraEntities())
            {
                var apuestas = db.APUESTAS.Where(x => x.Partido == idpartido).Select(x => x.Usuario).ToList();
                if (!apuestas.Contains(Convert.ToInt32(((ComboItem)CBUsuarios.SelectedItem).Value)))
                {
                   var nuevaapuesta = new APUESTAS();
                    nuevaapuesta.Partido = idpartido;
                    nuevaapuesta.Apuesta = valor;
                    nuevaapuesta.Usuario = Convert.ToInt32(((ComboItem)CBUsuarios.SelectedItem).Value);
                }
            }
        }

        private PARTIDOS getPartido()
        {
            using (bd_porraEntities db = new bd_porraEntities())
            {
                var nombreLocal = lista[0];
                var idLocal = db.EQUIPOS.Where(x => x.Nombre == nombreLocal).Select(x => x.Id_equipo).ToList()[0];
                var nombreVisita = lista[1];
                var idVisita = db.EQUIPOS.Where(x => x.Nombre == nombreVisita).Select(x => x.Id_equipo).ToList()[0];
                var fecha = DateTime.Parse(lista[2]);
                return db.PARTIDOS.Where(x => x.Equipo_local == idLocal && x.Equipo_visitante == idVisita && x.Fecha == fecha).Select(x => x).ToList()[0];
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
