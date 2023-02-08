namespace Plantillas.Forms
{
    partial class Cajas
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
            this.CBNormal = new System.Windows.Forms.ComboBox();
            this.CBSimple = new System.Windows.Forms.ComboBox();
            this.CBList = new System.Windows.Forms.ComboBox();
            this.SelectedColor = new System.Windows.Forms.TextBox();
            this.ColorToAdd = new System.Windows.Forms.TextBox();
            this.AddButton = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // CBNormal
            // 
            this.CBNormal.FormattingEnabled = true;
            this.CBNormal.Location = new System.Drawing.Point(135, 72);
            this.CBNormal.Name = "CBNormal";
            this.CBNormal.Size = new System.Drawing.Size(121, 23);
            this.CBNormal.TabIndex = 0;
            this.CBNormal.SelectedIndexChanged += new System.EventHandler(this.CBNormal_SelectedIndexChanged);
            // 
            // CBSimple
            // 
            this.CBSimple.DropDownStyle = System.Windows.Forms.ComboBoxStyle.Simple;
            this.CBSimple.FormattingEnabled = true;
            this.CBSimple.Location = new System.Drawing.Point(512, 72);
            this.CBSimple.Name = "CBSimple";
            this.CBSimple.Size = new System.Drawing.Size(121, 150);
            this.CBSimple.TabIndex = 1;
            this.CBSimple.SelectedIndexChanged += new System.EventHandler(this.CBSimple_SelectedIndexChanged);
            // 
            // CBList
            // 
            this.CBList.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.CBList.FlatStyle = System.Windows.Forms.FlatStyle.System;
            this.CBList.FormattingEnabled = true;
            this.CBList.Location = new System.Drawing.Point(320, 72);
            this.CBList.Name = "CBList";
            this.CBList.Size = new System.Drawing.Size(121, 23);
            this.CBList.TabIndex = 2;
            this.CBList.SelectedIndexChanged += new System.EventHandler(this.CBList_SelectedIndexChanged);
            // 
            // SelectedColor
            // 
            this.SelectedColor.Location = new System.Drawing.Point(320, 255);
            this.SelectedColor.Name = "SelectedColor";
            this.SelectedColor.Size = new System.Drawing.Size(100, 23);
            this.SelectedColor.TabIndex = 3;
            // 
            // ColorToAdd
            // 
            this.ColorToAdd.Location = new System.Drawing.Point(156, 305);
            this.ColorToAdd.Name = "ColorToAdd";
            this.ColorToAdd.Size = new System.Drawing.Size(100, 23);
            this.ColorToAdd.TabIndex = 4;
            // 
            // AddButton
            // 
            this.AddButton.Location = new System.Drawing.Point(272, 305);
            this.AddButton.Name = "AddButton";
            this.AddButton.Size = new System.Drawing.Size(340, 23);
            this.AddButton.TabIndex = 5;
            this.AddButton.Text = "Añadir color ";
            this.AddButton.UseVisualStyleBackColor = true;
            this.AddButton.Click += new System.EventHandler(this.BTNAddColor);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(135, 263);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(115, 15);
            this.label2.TabIndex = 7;
            this.label2.Text = "Ultimo color elegido";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(135, 40);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(64, 15);
            this.label3.TabIndex = 8;
            this.label3.Text = "DropDown";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(320, 40);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(82, 15);
            this.label4.TabIndex = 9;
            this.label4.Text = "DropDownList";
            this.label4.Click += new System.EventHandler(this.label4_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(512, 40);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(106, 15);
            this.label5.TabIndex = 10;
            this.label5.Text = "Simple ComboBox";
            // 
            // Cajas
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.AddButton);
            this.Controls.Add(this.ColorToAdd);
            this.Controls.Add(this.SelectedColor);
            this.Controls.Add(this.CBList);
            this.Controls.Add(this.CBSimple);
            this.Controls.Add(this.CBNormal);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Cajas";
            this.Text = "Cajas";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private ComboBox CBNormal;
        private ComboBox CBSimple;
        private ComboBox CBList;
        private TextBox SelectedColor;
        private TextBox ColorToAdd;
        private Button AddButton;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
    }
}