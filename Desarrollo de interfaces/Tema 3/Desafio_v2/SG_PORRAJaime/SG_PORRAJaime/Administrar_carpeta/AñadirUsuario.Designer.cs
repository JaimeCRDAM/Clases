namespace SG_PORRAJaime.Administrar_carpeta
{
    partial class AñadirUsuario
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.BTNVolver = new System.Windows.Forms.Button();
            this.BTNAceptar = new System.Windows.Forms.Button();
            this.TBCif = new System.Windows.Forms.TextBox();
            this.TBDomicilio = new System.Windows.Forms.TextBox();
            this.TBEmail = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.TBCodigoPostal = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // BTNVolver
            // 
            this.BTNVolver.Location = new System.Drawing.Point(130, 178);
            this.BTNVolver.Name = "BTNVolver";
            this.BTNVolver.Size = new System.Drawing.Size(75, 23);
            this.BTNVolver.TabIndex = 32;
            this.BTNVolver.Text = "Volver";
            this.BTNVolver.UseVisualStyleBackColor = true;
            this.BTNVolver.Click += new System.EventHandler(this.BTNVolver_Click);
            // 
            // BTNAceptar
            // 
            this.BTNAceptar.Location = new System.Drawing.Point(14, 178);
            this.BTNAceptar.Name = "BTNAceptar";
            this.BTNAceptar.Size = new System.Drawing.Size(75, 23);
            this.BTNAceptar.TabIndex = 31;
            this.BTNAceptar.Text = "Aceptar";
            this.BTNAceptar.UseVisualStyleBackColor = true;
            this.BTNAceptar.Click += new System.EventHandler(this.BTNAceptar_Click);
            // 
            // TBCif
            // 
            this.TBCif.Location = new System.Drawing.Point(112, 25);
            this.TBCif.Name = "TBCif";
            this.TBCif.Size = new System.Drawing.Size(100, 20);
            this.TBCif.TabIndex = 30;
            // 
            // TBDomicilio
            // 
            this.TBDomicilio.Location = new System.Drawing.Point(112, 93);
            this.TBDomicilio.Name = "TBDomicilio";
            this.TBDomicilio.Size = new System.Drawing.Size(100, 20);
            this.TBDomicilio.TabIndex = 29;
            // 
            // TBEmail
            // 
            this.TBEmail.Location = new System.Drawing.Point(112, 60);
            this.TBEmail.Name = "TBEmail";
            this.TBEmail.Size = new System.Drawing.Size(100, 20);
            this.TBEmail.TabIndex = 28;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(11, 129);
            this.label7.Name = "label7";
            this.label7.Padding = new System.Windows.Forms.Padding(0, 0, 0, 20);
            this.label7.Size = new System.Drawing.Size(97, 33);
            this.label7.TabIndex = 27;
            this.label7.Text = "CODIGO POSTAL:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(11, 96);
            this.label6.Name = "label6";
            this.label6.Padding = new System.Windows.Forms.Padding(0, 0, 0, 20);
            this.label6.Size = new System.Drawing.Size(65, 33);
            this.label6.TabIndex = 26;
            this.label6.Text = "DOMICILIO:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(11, 63);
            this.label5.Name = "label5";
            this.label5.Padding = new System.Windows.Forms.Padding(0, 0, 0, 20);
            this.label5.Size = new System.Drawing.Size(42, 33);
            this.label5.TabIndex = 25;
            this.label5.Text = "EMAIL:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(11, 10);
            this.label1.Name = "label1";
            this.label1.Padding = new System.Windows.Forms.Padding(0, 20, 0, 20);
            this.label1.Size = new System.Drawing.Size(29, 53);
            this.label1.TabIndex = 24;
            this.label1.Text = "DNI:";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // TBCodigoPostal
            // 
            this.TBCodigoPostal.Location = new System.Drawing.Point(112, 126);
            this.TBCodigoPostal.Name = "TBCodigoPostal";
            this.TBCodigoPostal.Size = new System.Drawing.Size(100, 20);
            this.TBCodigoPostal.TabIndex = 33;
            // 
            // AñadirUsuario
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDark;
            this.ClientSize = new System.Drawing.Size(224, 215);
            this.Controls.Add(this.TBCodigoPostal);
            this.Controls.Add(this.BTNVolver);
            this.Controls.Add(this.BTNAceptar);
            this.Controls.Add(this.TBCif);
            this.Controls.Add(this.TBDomicilio);
            this.Controls.Add(this.TBEmail);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "AñadirUsuario";
            this.Text = "AñadirUsuario";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button BTNVolver;
        private System.Windows.Forms.Button BTNAceptar;
        private System.Windows.Forms.TextBox TBCif;
        private System.Windows.Forms.TextBox TBDomicilio;
        private System.Windows.Forms.TextBox TBEmail;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox TBCodigoPostal;
    }
}