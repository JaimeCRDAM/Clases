namespace Plantillas.Forms
{
    partial class Colores
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
            this.BTNColor = new System.Windows.Forms.Button();
            this.BTNLetra = new System.Windows.Forms.Button();
            this.TEXTBColoresLetra = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // BTNColor
            // 
            this.BTNColor.Location = new System.Drawing.Point(168, 88);
            this.BTNColor.Name = "BTNColor";
            this.BTNColor.Size = new System.Drawing.Size(75, 23);
            this.BTNColor.TabIndex = 0;
            this.BTNColor.Text = "Color";
            this.BTNColor.UseVisualStyleBackColor = true;
            this.BTNColor.Click += new System.EventHandler(this.BTNColor_Click);
            // 
            // BTNLetra
            // 
            this.BTNLetra.Location = new System.Drawing.Point(586, 88);
            this.BTNLetra.Name = "BTNLetra";
            this.BTNLetra.Size = new System.Drawing.Size(75, 23);
            this.BTNLetra.TabIndex = 1;
            this.BTNLetra.Text = "Letra";
            this.BTNLetra.UseVisualStyleBackColor = true;
            this.BTNLetra.Click += new System.EventHandler(this.BTNLetra_Click);
            // 
            // TEXTBColoresLetra
            // 
            this.TEXTBColoresLetra.Location = new System.Drawing.Point(345, 205);
            this.TEXTBColoresLetra.Name = "TEXTBColoresLetra";
            this.TEXTBColoresLetra.Size = new System.Drawing.Size(100, 23);
            this.TEXTBColoresLetra.TabIndex = 2;
            // 
            // Colores
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.None;
            this.CausesValidation = false;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.TEXTBColoresLetra);
            this.Controls.Add(this.BTNLetra);
            this.Controls.Add(this.BTNColor);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Colores";
            this.Text = "Colores";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Button BTNColor;
        private Button BTNLetra;
        private TextBox TEXTBColoresLetra;
    }
}