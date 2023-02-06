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

namespace SG_PORRAJaime.Partidos_carpeta
{
    public partial class Lista : Form
    {
        public Lista()
        {
            InitializeComponent();
            RefreshDGV();
        }
        private void RefreshDGV()
        {
            using (bd_porraEntities db = new bd_porraEntities())
            {
                var partidos = db.PARTIDOS.Select(x => new {
                    local = db.EQUIPOS.Where(y => x.Equipo_local == y.Id_equipo).Select(y => y.Nombre).FirstOrDefault(),
                    visitante = db.EQUIPOS.Where(y => x.Equipo_visitante == y.Id_equipo).Select(y => y.Nombre).FirstOrDefault(),
                    x.Fecha,
                    x.Hora,
                    x.Resultado

                }).ToList();
                DGVPartidos.DataSource = partidos;
                foreach (DataGridViewColumn item in DGVPartidos.Columns)
                {
                    item.AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill;
                }
            }
        }

        private void BTNApuesta_Click(object sender, EventArgs e)
        {
            using (bd_porraEntities db = new bd_porraEntities())
            {
                var listaToPass = new List<string>();

                listaToPass.Add(DGVPartidos.SelectedRows[0].Cells[0].Value.ToString());
                listaToPass.Add(DGVPartidos.SelectedRows[0].Cells[1].Value.ToString());
                listaToPass.Add(DGVPartidos.SelectedRows[0].Cells[2].Value.ToString());
                listaToPass.Add(DGVPartidos.SelectedRows[0].Cells[3].Value.ToString());

                Form modUsuarios = new Apuestas(listaToPass);
                modUsuarios.ShowDialog();
                RefreshDGV();
            }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            using (bd_porraEntities db = new bd_porraEntities())
            {
                var listaToPass = new List<string>();

                listaToPass.Add(DGVPartidos.SelectedRows[0].Cells[0].Value.ToString());
                listaToPass.Add(DGVPartidos.SelectedRows[0].Cells[1].Value.ToString());
                listaToPass.Add(DGVPartidos.SelectedRows[0].Cells[2].Value.ToString());
                listaToPass.Add(DGVPartidos.SelectedRows[0].Cells[3].Value.ToString());


                Form modUsuarios = new Resultado(listaToPass);
                modUsuarios.ShowDialog();
                RefreshDGV();
            }
        }
    }
}
