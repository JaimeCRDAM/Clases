namespace WinFormsApp1
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.Windows.Forms.ListViewItem listViewItem1 = new System.Windows.Forms.ListViewItem(new string[] {
            "Acceso a datos",
            "sdgsdg"}, -1);
            System.Windows.Forms.ListViewItem listViewItem2 = new System.Windows.Forms.ListViewItem("Desarrollo de interfaces");
            System.Windows.Forms.ListViewItem listViewItem3 = new System.Windows.Forms.ListViewItem("Gestion empre");
            System.Windows.Forms.ListViewItem listViewItem4 = new System.Windows.Forms.ListViewItem("Iniciativa empre");
            System.Windows.Forms.ListViewItem listViewItem5 = new System.Windows.Forms.ListViewItem("Procesos");
            System.Windows.Forms.ListViewItem listViewItem6 = new System.Windows.Forms.ListViewItem("Programacion");
            this.DGVHorario = new System.Windows.Forms.DataGridView();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.CBDia = new System.Windows.Forms.ComboBox();
            this.CBHora = new System.Windows.Forms.ComboBox();
            this.BTNGuardar = new System.Windows.Forms.Button();
            this.BTNCargar = new System.Windows.Forms.Button();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.CBCurso = new System.Windows.Forms.ComboBox();
            this.LVModulos = new System.Windows.Forms.ListView();
            this.columnHeader1 = new System.Windows.Forms.ColumnHeader();
            this.LVCiclo = new System.Windows.Forms.ListView();
            this.BTNAnadir = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.DGVHorario)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // DGVHorario
            // 
            this.DGVHorario.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.DGVHorario.Location = new System.Drawing.Point(12, 12);
            this.DGVHorario.Name = "DGVHorario";
            this.DGVHorario.RowTemplate.Height = 25;
            this.DGVHorario.Size = new System.Drawing.Size(776, 206);
            this.DGVHorario.TabIndex = 0;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.label5);
            this.groupBox1.Controls.Add(this.CBDia);
            this.groupBox1.Controls.Add(this.CBHora);
            this.groupBox1.Location = new System.Drawing.Point(12, 251);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(200, 100);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Horario";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(29, 54);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(24, 15);
            this.label4.TabIndex = 6;
            this.label4.Text = "Día";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(29, 25);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(33, 15);
            this.label5.TabIndex = 7;
            this.label5.Text = "Hora";
            // 
            // CBDia
            // 
            this.CBDia.FormattingEnabled = true;
            this.CBDia.Items.AddRange(new object[] {
            "Lunes",
            "Martes",
            "Miercoles",
            "Jueves",
            "Viernes"});
            this.CBDia.Location = new System.Drawing.Point(73, 51);
            this.CBDia.Name = "CBDia";
            this.CBDia.Size = new System.Drawing.Size(121, 23);
            this.CBDia.TabIndex = 1;
            // 
            // CBHora
            // 
            this.CBHora.FormattingEnabled = true;
            this.CBHora.Items.AddRange(new object[] {
            "Primera",
            "Segunda",
            "Tercera",
            "Cuarta",
            "Quinta",
            "Sexta"});
            this.CBHora.Location = new System.Drawing.Point(73, 22);
            this.CBHora.Name = "CBHora";
            this.CBHora.Size = new System.Drawing.Size(121, 23);
            this.CBHora.TabIndex = 0;
            this.CBHora.SelectedIndexChanged += new System.EventHandler(this.CBHora_SelectedIndexChanged);
            // 
            // BTNGuardar
            // 
            this.BTNGuardar.Location = new System.Drawing.Point(12, 357);
            this.BTNGuardar.Name = "BTNGuardar";
            this.BTNGuardar.Size = new System.Drawing.Size(200, 23);
            this.BTNGuardar.TabIndex = 2;
            this.BTNGuardar.Text = "Guardar horario";
            this.BTNGuardar.UseVisualStyleBackColor = true;
            this.BTNGuardar.Click += new System.EventHandler(this.BTNGuardar_Click);
            // 
            // BTNCargar
            // 
            this.BTNCargar.Location = new System.Drawing.Point(12, 386);
            this.BTNCargar.Name = "BTNCargar";
            this.BTNCargar.Size = new System.Drawing.Size(200, 23);
            this.BTNCargar.TabIndex = 3;
            this.BTNCargar.Text = "Cargar horario";
            this.BTNCargar.UseVisualStyleBackColor = true;
            this.BTNCargar.Click += new System.EventHandler(this.BTNCargar_Click);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.label3);
            this.groupBox2.Controls.Add(this.label2);
            this.groupBox2.Controls.Add(this.label1);
            this.groupBox2.Controls.Add(this.CBCurso);
            this.groupBox2.Controls.Add(this.LVModulos);
            this.groupBox2.Controls.Add(this.LVCiclo);
            this.groupBox2.Location = new System.Drawing.Point(227, 251);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(561, 165);
            this.groupBox2.TabIndex = 2;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Datos del curso";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(225, 22);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(38, 15);
            this.label3.TabIndex = 5;
            this.label3.Text = "Curso";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(124, 30);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(34, 15);
            this.label2.TabIndex = 4;
            this.label2.Text = "Ciclo";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(200, 36);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(54, 15);
            this.label1.TabIndex = 3;
            this.label1.Text = "Modulos";
            // 
            // CBCurso
            // 
            this.CBCurso.FormattingEnabled = true;
            this.CBCurso.Items.AddRange(new object[] {
            "Segundo"});
            this.CBCurso.Location = new System.Drawing.Point(269, 22);
            this.CBCurso.Name = "CBCurso";
            this.CBCurso.Size = new System.Drawing.Size(121, 23);
            this.CBCurso.TabIndex = 2;
            // 
            // LVModulos
            // 
            this.LVModulos.AutoArrange = false;
            this.LVModulos.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader1});
            this.LVModulos.HeaderStyle = System.Windows.Forms.ColumnHeaderStyle.None;
            listViewItem1.ToolTipText = "asfasfasf";
            this.LVModulos.Items.AddRange(new System.Windows.Forms.ListViewItem[] {
            listViewItem1,
            listViewItem2,
            listViewItem3,
            listViewItem4,
            listViewItem5,
            listViewItem6});
            this.LVModulos.Location = new System.Drawing.Point(200, 54);
            this.LVModulos.Margin = new System.Windows.Forms.Padding(3, 3, 3, 0);
            this.LVModulos.Name = "LVModulos";
            this.LVModulos.Size = new System.Drawing.Size(190, 106);
            this.LVModulos.TabIndex = 1;
            this.LVModulos.UseCompatibleStateImageBehavior = false;
            this.LVModulos.View = System.Windows.Forms.View.Details;
            // 
            // columnHeader1
            // 
            this.columnHeader1.Text = "";
            this.columnHeader1.Width = 200;
            // 
            // LVCiclo
            // 
            this.LVCiclo.Location = new System.Drawing.Point(124, 51);
            this.LVCiclo.Name = "LVCiclo";
            this.LVCiclo.Size = new System.Drawing.Size(70, 109);
            this.LVCiclo.TabIndex = 0;
            this.LVCiclo.UseCompatibleStateImageBehavior = false;
            // 
            // BTNAnadir
            // 
            this.BTNAnadir.Location = new System.Drawing.Point(763, 428);
            this.BTNAnadir.Name = "BTNAnadir";
            this.BTNAnadir.Size = new System.Drawing.Size(25, 23);
            this.BTNAnadir.TabIndex = 4;
            this.BTNAnadir.Text = "button1";
            this.BTNAnadir.UseVisualStyleBackColor = true;
            this.BTNAnadir.Click += new System.EventHandler(this.BTNAnadir_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.BTNAnadir);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.BTNCargar);
            this.Controls.Add(this.BTNGuardar);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.DGVHorario);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.DGVHorario)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private DataGridView DGVHorario;
        private GroupBox groupBox1;
        private Label label4;
        private Label label5;
        private ComboBox CBDia;
        private ComboBox CBHora;
        private Button BTNGuardar;
        private Button BTNCargar;
        private GroupBox groupBox2;
        private Label label3;
        private Label label2;
        private Label label1;
        private ComboBox CBCurso;
        private ListView LVModulos;
        private ListView LVCiclo;
        private ColumnHeader columnHeader1;
        private Button BTNAnadir;
    }
}