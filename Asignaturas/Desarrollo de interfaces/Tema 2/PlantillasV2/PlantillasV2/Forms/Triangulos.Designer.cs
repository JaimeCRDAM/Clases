namespace PlantillasV2.Forms
{
    partial class Triangulos
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
            this.BTNComprobar = new System.Windows.Forms.Button();
            this.TBLadoC = new System.Windows.Forms.TextBox();
            this.TBLadoB = new System.Windows.Forms.TextBox();
            this.TBLadoA = new System.Windows.Forms.TextBox();
            this.LBLadoB = new System.Windows.Forms.Label();
            this.LBLadoC = new System.Windows.Forms.Label();
            this.LBLadoA = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // BTNComprobar
            // 
            this.BTNComprobar.Location = new System.Drawing.Point(69, 161);
            this.BTNComprobar.Name = "BTNComprobar";
            this.BTNComprobar.Size = new System.Drawing.Size(188, 23);
            this.BTNComprobar.TabIndex = 13;
            this.BTNComprobar.Text = "Comprobar triangulo";
            this.BTNComprobar.UseVisualStyleBackColor = true;
            this.BTNComprobar.Click += new System.EventHandler(this.BTNComprobar_Click);
            // 
            // TBLadoC
            // 
            this.TBLadoC.Location = new System.Drawing.Point(132, 118);
            this.TBLadoC.Name = "TBLadoC";
            this.TBLadoC.Size = new System.Drawing.Size(100, 23);
            this.TBLadoC.TabIndex = 12;
            // 
            // TBLadoB
            // 
            this.TBLadoB.Location = new System.Drawing.Point(132, 89);
            this.TBLadoB.Name = "TBLadoB";
            this.TBLadoB.Size = new System.Drawing.Size(100, 23);
            this.TBLadoB.TabIndex = 11;
            // 
            // TBLadoA
            // 
            this.TBLadoA.Location = new System.Drawing.Point(132, 60);
            this.TBLadoA.Name = "TBLadoA";
            this.TBLadoA.Size = new System.Drawing.Size(100, 23);
            this.TBLadoA.TabIndex = 10;
            // 
            // LBLadoB
            // 
            this.LBLadoB.AutoSize = true;
            this.LBLadoB.Location = new System.Drawing.Point(83, 92);
            this.LBLadoB.Name = "LBLadoB";
            this.LBLadoB.Size = new System.Drawing.Size(43, 15);
            this.LBLadoB.TabIndex = 9;
            this.LBLadoB.Text = "Lado B";
            // 
            // LBLadoC
            // 
            this.LBLadoC.AutoSize = true;
            this.LBLadoC.Location = new System.Drawing.Point(82, 121);
            this.LBLadoC.Name = "LBLadoC";
            this.LBLadoC.Size = new System.Drawing.Size(44, 15);
            this.LBLadoC.TabIndex = 8;
            this.LBLadoC.Text = "Lado C";
            // 
            // LBLadoA
            // 
            this.LBLadoA.AutoSize = true;
            this.LBLadoA.Location = new System.Drawing.Point(82, 63);
            this.LBLadoA.Name = "LBLadoA";
            this.LBLadoA.Size = new System.Drawing.Size(44, 15);
            this.LBLadoA.TabIndex = 7;
            this.LBLadoA.Text = "Lado A";
            // 
            // Triangulos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.BTNComprobar);
            this.Controls.Add(this.TBLadoC);
            this.Controls.Add(this.TBLadoB);
            this.Controls.Add(this.TBLadoA);
            this.Controls.Add(this.LBLadoB);
            this.Controls.Add(this.LBLadoC);
            this.Controls.Add(this.LBLadoA);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Triangulos";
            this.Text = "Triangulos";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Button BTNComprobar;
        private TextBox TBLadoC;
        private TextBox TBLadoB;
        private TextBox TBLadoA;
        private Label LBLadoB;
        private Label LBLadoC;
        private Label LBLadoA;
    }
}