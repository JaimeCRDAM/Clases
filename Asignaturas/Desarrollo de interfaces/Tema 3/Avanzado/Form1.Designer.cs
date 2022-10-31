namespace Avanzado
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            System.Windows.Forms.Label codpeliLabel;
            System.Windows.Forms.Label tituloLabel;
            System.Windows.Forms.Label directorLabel;
            System.Windows.Forms.Label protagonistaLabel;
            System.Windows.Forms.Label argumentoLabel;
            System.Windows.Forms.Label estiloLabel;
            System.Windows.Forms.Label anioLabel;
            System.Windows.Forms.Label caratulaLabel;
            System.Windows.Forms.Label categoriaLabel;
            System.Windows.Forms.Label stockLabel;
            this.vcb = new Avanzado.vcb();
            this.peliculasBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.peliculasTableAdapter = new Avanzado.vcbTableAdapters.peliculasTableAdapter();
            this.tableAdapterManager = new Avanzado.vcbTableAdapters.TableAdapterManager();
            this.peliculasBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
            this.bindingNavigatorMoveFirstItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMovePreviousItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorPositionItem = new System.Windows.Forms.ToolStripTextBox();
            this.bindingNavigatorCountItem = new System.Windows.Forms.ToolStripLabel();
            this.bindingNavigatorSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorMoveNextItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveLastItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorAddNewItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorDeleteItem = new System.Windows.Forms.ToolStripButton();
            this.peliculasBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.codpeliLabel1 = new System.Windows.Forms.Label();
            this.tituloTextBox = new System.Windows.Forms.TextBox();
            this.directorTextBox = new System.Windows.Forms.TextBox();
            this.protagonistaTextBox = new System.Windows.Forms.TextBox();
            this.argumentoTextBox = new System.Windows.Forms.TextBox();
            this.estiloComboBox = new System.Windows.Forms.ComboBox();
            this.anioLabel1 = new System.Windows.Forms.Label();
            this.caratulaPictureBox = new System.Windows.Forms.PictureBox();
            this.categoriaComboBox = new System.Windows.Forms.ComboBox();
            this.stockNumericUpDown = new System.Windows.Forms.NumericUpDown();
            this.BTNCaratula = new System.Windows.Forms.Button();
            codpeliLabel = new System.Windows.Forms.Label();
            tituloLabel = new System.Windows.Forms.Label();
            directorLabel = new System.Windows.Forms.Label();
            protagonistaLabel = new System.Windows.Forms.Label();
            argumentoLabel = new System.Windows.Forms.Label();
            estiloLabel = new System.Windows.Forms.Label();
            anioLabel = new System.Windows.Forms.Label();
            caratulaLabel = new System.Windows.Forms.Label();
            categoriaLabel = new System.Windows.Forms.Label();
            stockLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.vcb)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.peliculasBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.peliculasBindingNavigator)).BeginInit();
            this.peliculasBindingNavigator.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.caratulaPictureBox)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.stockNumericUpDown)).BeginInit();
            this.SuspendLayout();
            // 
            // vcb
            // 
            this.vcb.DataSetName = "vcb";
            this.vcb.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // peliculasBindingSource
            // 
            this.peliculasBindingSource.DataMember = "peliculas";
            this.peliculasBindingSource.DataSource = this.vcb;
            // 
            // peliculasTableAdapter
            // 
            this.peliculasTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.alquileresTableAdapter = null;
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.categoriasTableAdapter = null;
            this.tableAdapterManager.estilosTableAdapter = null;
            this.tableAdapterManager.peliculasTableAdapter = this.peliculasTableAdapter;
            this.tableAdapterManager.sociosTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = Avanzado.vcbTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // peliculasBindingNavigator
            // 
            this.peliculasBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.peliculasBindingNavigator.BindingSource = this.peliculasBindingSource;
            this.peliculasBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.peliculasBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.peliculasBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.bindingNavigatorMoveFirstItem,
            this.bindingNavigatorMovePreviousItem,
            this.bindingNavigatorSeparator,
            this.bindingNavigatorPositionItem,
            this.bindingNavigatorCountItem,
            this.bindingNavigatorSeparator1,
            this.bindingNavigatorMoveNextItem,
            this.bindingNavigatorMoveLastItem,
            this.bindingNavigatorSeparator2,
            this.bindingNavigatorAddNewItem,
            this.bindingNavigatorDeleteItem,
            this.peliculasBindingNavigatorSaveItem});
            this.peliculasBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.peliculasBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.peliculasBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.peliculasBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.peliculasBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.peliculasBindingNavigator.Name = "peliculasBindingNavigator";
            this.peliculasBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.peliculasBindingNavigator.Size = new System.Drawing.Size(800, 25);
            this.peliculasBindingNavigator.TabIndex = 0;
            this.peliculasBindingNavigator.Text = "bindingNavigator1";
            this.peliculasBindingNavigator.RefreshItems += new System.EventHandler(this.peliculasBindingNavigator_RefreshItems);
            // 
            // bindingNavigatorMoveFirstItem
            // 
            this.bindingNavigatorMoveFirstItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveFirstItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveFirstItem.Image")));
            this.bindingNavigatorMoveFirstItem.Name = "bindingNavigatorMoveFirstItem";
            this.bindingNavigatorMoveFirstItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveFirstItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveFirstItem.Text = "Mover primero";
            // 
            // bindingNavigatorMovePreviousItem
            // 
            this.bindingNavigatorMovePreviousItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMovePreviousItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMovePreviousItem.Image")));
            this.bindingNavigatorMovePreviousItem.Name = "bindingNavigatorMovePreviousItem";
            this.bindingNavigatorMovePreviousItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMovePreviousItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMovePreviousItem.Text = "Mover anterior";
            // 
            // bindingNavigatorSeparator
            // 
            this.bindingNavigatorSeparator.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorPositionItem
            // 
            this.bindingNavigatorPositionItem.AccessibleName = "Posición";
            this.bindingNavigatorPositionItem.AutoSize = false;
            this.bindingNavigatorPositionItem.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.bindingNavigatorPositionItem.Name = "bindingNavigatorPositionItem";
            this.bindingNavigatorPositionItem.Size = new System.Drawing.Size(50, 23);
            this.bindingNavigatorPositionItem.Text = "0";
            this.bindingNavigatorPositionItem.ToolTipText = "Posición actual";
            // 
            // bindingNavigatorCountItem
            // 
            this.bindingNavigatorCountItem.Name = "bindingNavigatorCountItem";
            this.bindingNavigatorCountItem.Size = new System.Drawing.Size(37, 22);
            this.bindingNavigatorCountItem.Text = "de {0}";
            this.bindingNavigatorCountItem.ToolTipText = "Número total de elementos";
            // 
            // bindingNavigatorSeparator1
            // 
            this.bindingNavigatorSeparator1.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator1.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorMoveNextItem
            // 
            this.bindingNavigatorMoveNextItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveNextItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveNextItem.Image")));
            this.bindingNavigatorMoveNextItem.Name = "bindingNavigatorMoveNextItem";
            this.bindingNavigatorMoveNextItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveNextItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveNextItem.Text = "Mover siguiente";
            // 
            // bindingNavigatorMoveLastItem
            // 
            this.bindingNavigatorMoveLastItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveLastItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveLastItem.Image")));
            this.bindingNavigatorMoveLastItem.Name = "bindingNavigatorMoveLastItem";
            this.bindingNavigatorMoveLastItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveLastItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveLastItem.Text = "Mover último";
            // 
            // bindingNavigatorSeparator2
            // 
            this.bindingNavigatorSeparator2.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator2.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorAddNewItem
            // 
            this.bindingNavigatorAddNewItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorAddNewItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorAddNewItem.Image")));
            this.bindingNavigatorAddNewItem.Name = "bindingNavigatorAddNewItem";
            this.bindingNavigatorAddNewItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorAddNewItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorAddNewItem.Text = "Agregar nuevo";
            // 
            // bindingNavigatorDeleteItem
            // 
            this.bindingNavigatorDeleteItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorDeleteItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorDeleteItem.Image")));
            this.bindingNavigatorDeleteItem.Name = "bindingNavigatorDeleteItem";
            this.bindingNavigatorDeleteItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorDeleteItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorDeleteItem.Text = "Eliminar";
            // 
            // peliculasBindingNavigatorSaveItem
            // 
            this.peliculasBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.peliculasBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("peliculasBindingNavigatorSaveItem.Image")));
            this.peliculasBindingNavigatorSaveItem.Name = "peliculasBindingNavigatorSaveItem";
            this.peliculasBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.peliculasBindingNavigatorSaveItem.Text = "Guardar datos";
            this.peliculasBindingNavigatorSaveItem.Click += new System.EventHandler(this.peliculasBindingNavigatorSaveItem_Click_3);
            // 
            // codpeliLabel
            // 
            codpeliLabel.AutoSize = true;
            codpeliLabel.Location = new System.Drawing.Point(45, 40);
            codpeliLabel.Name = "codpeliLabel";
            codpeliLabel.Size = new System.Drawing.Size(44, 13);
            codpeliLabel.TabIndex = 1;
            codpeliLabel.Text = "codpeli:";
            // 
            // codpeliLabel1
            // 
            this.codpeliLabel1.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.peliculasBindingSource, "codpeli", true));
            this.codpeliLabel1.Location = new System.Drawing.Point(315, 40);
            this.codpeliLabel1.Name = "codpeliLabel1";
            this.codpeliLabel1.Size = new System.Drawing.Size(121, 23);
            this.codpeliLabel1.TabIndex = 2;
            this.codpeliLabel1.Text = "label1";
            // 
            // tituloLabel
            // 
            tituloLabel.AutoSize = true;
            tituloLabel.Location = new System.Drawing.Point(45, 69);
            tituloLabel.Name = "tituloLabel";
            tituloLabel.Size = new System.Drawing.Size(32, 13);
            tituloLabel.TabIndex = 3;
            tituloLabel.Text = "titulo:";
            // 
            // tituloTextBox
            // 
            this.tituloTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.peliculasBindingSource, "titulo", true));
            this.tituloTextBox.Location = new System.Drawing.Point(119, 66);
            this.tituloTextBox.Name = "tituloTextBox";
            this.tituloTextBox.Size = new System.Drawing.Size(317, 20);
            this.tituloTextBox.TabIndex = 4;
            this.tituloTextBox.TextChanged += new System.EventHandler(this.tituloTextBox_TextChanged);
            // 
            // directorLabel
            // 
            directorLabel.AutoSize = true;
            directorLabel.Location = new System.Drawing.Point(45, 95);
            directorLabel.Name = "directorLabel";
            directorLabel.Size = new System.Drawing.Size(45, 13);
            directorLabel.TabIndex = 5;
            directorLabel.Text = "director:";
            // 
            // directorTextBox
            // 
            this.directorTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.peliculasBindingSource, "director", true));
            this.directorTextBox.Location = new System.Drawing.Point(119, 92);
            this.directorTextBox.Name = "directorTextBox";
            this.directorTextBox.Size = new System.Drawing.Size(317, 20);
            this.directorTextBox.TabIndex = 6;
            // 
            // protagonistaLabel
            // 
            protagonistaLabel.AutoSize = true;
            protagonistaLabel.Location = new System.Drawing.Point(45, 121);
            protagonistaLabel.Name = "protagonistaLabel";
            protagonistaLabel.Size = new System.Drawing.Size(68, 13);
            protagonistaLabel.TabIndex = 7;
            protagonistaLabel.Text = "protagonista:";
            // 
            // protagonistaTextBox
            // 
            this.protagonistaTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.peliculasBindingSource, "protagonista", true));
            this.protagonistaTextBox.Location = new System.Drawing.Point(119, 118);
            this.protagonistaTextBox.Name = "protagonistaTextBox";
            this.protagonistaTextBox.Size = new System.Drawing.Size(317, 20);
            this.protagonistaTextBox.TabIndex = 8;
            // 
            // argumentoLabel
            // 
            argumentoLabel.AutoSize = true;
            argumentoLabel.Location = new System.Drawing.Point(45, 147);
            argumentoLabel.Name = "argumentoLabel";
            argumentoLabel.Size = new System.Drawing.Size(60, 13);
            argumentoLabel.TabIndex = 9;
            argumentoLabel.Text = "argumento:";
            // 
            // argumentoTextBox
            // 
            this.argumentoTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.peliculasBindingSource, "argumento", true));
            this.argumentoTextBox.Location = new System.Drawing.Point(119, 144);
            this.argumentoTextBox.Multiline = true;
            this.argumentoTextBox.Name = "argumentoTextBox";
            this.argumentoTextBox.Size = new System.Drawing.Size(317, 131);
            this.argumentoTextBox.TabIndex = 10;
            // 
            // estiloLabel
            // 
            estiloLabel.AutoSize = true;
            estiloLabel.Location = new System.Drawing.Point(45, 314);
            estiloLabel.Name = "estiloLabel";
            estiloLabel.Size = new System.Drawing.Size(34, 13);
            estiloLabel.TabIndex = 11;
            estiloLabel.Text = "estilo:";
            // 
            // estiloComboBox
            // 
            this.estiloComboBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.peliculasBindingSource, "estilo", true));
            this.estiloComboBox.FormattingEnabled = true;
            this.estiloComboBox.Location = new System.Drawing.Point(119, 311);
            this.estiloComboBox.Name = "estiloComboBox";
            this.estiloComboBox.Size = new System.Drawing.Size(215, 21);
            this.estiloComboBox.TabIndex = 12;
            // 
            // anioLabel
            // 
            anioLabel.AutoSize = true;
            anioLabel.Location = new System.Drawing.Point(241, 40);
            anioLabel.Name = "anioLabel";
            anioLabel.Size = new System.Drawing.Size(30, 13);
            anioLabel.TabIndex = 13;
            anioLabel.Text = "anio:";
            anioLabel.Click += new System.EventHandler(this.anioLabel_Click);
            // 
            // anioLabel1
            // 
            this.anioLabel1.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.peliculasBindingSource, "anio", true));
            this.anioLabel1.Location = new System.Drawing.Point(225, 40);
            this.anioLabel1.Name = "anioLabel1";
            this.anioLabel1.Size = new System.Drawing.Size(121, 23);
            this.anioLabel1.TabIndex = 14;
            this.anioLabel1.Text = "label1";
            this.anioLabel1.Click += new System.EventHandler(this.anioLabel1_Click);
            // 
            // caratulaLabel
            // 
            caratulaLabel.AutoSize = true;
            caratulaLabel.Location = new System.Drawing.Point(464, 40);
            caratulaLabel.Name = "caratulaLabel";
            caratulaLabel.Size = new System.Drawing.Size(48, 13);
            caratulaLabel.TabIndex = 15;
            caratulaLabel.Text = "caratula:";
            caratulaLabel.Click += new System.EventHandler(this.caratulaLabel_Click);
            // 
            // caratulaPictureBox
            // 
            this.caratulaPictureBox.DataBindings.Add(new System.Windows.Forms.Binding("Image", this.peliculasBindingSource, "caratula", true));
            this.caratulaPictureBox.Location = new System.Drawing.Point(467, 87);
            this.caratulaPictureBox.Name = "caratulaPictureBox";
            this.caratulaPictureBox.Size = new System.Drawing.Size(121, 188);
            this.caratulaPictureBox.SizeMode = System.Windows.Forms.PictureBoxSizeMode.AutoSize;
            this.caratulaPictureBox.TabIndex = 16;
            this.caratulaPictureBox.TabStop = false;
            // 
            // categoriaLabel
            // 
            categoriaLabel.AutoSize = true;
            categoriaLabel.Location = new System.Drawing.Point(45, 284);
            categoriaLabel.Name = "categoriaLabel";
            categoriaLabel.Size = new System.Drawing.Size(54, 13);
            categoriaLabel.TabIndex = 17;
            categoriaLabel.Text = "categoria:";
            // 
            // categoriaComboBox
            // 
            this.categoriaComboBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.peliculasBindingSource, "categoria", true));
            this.categoriaComboBox.FormattingEnabled = true;
            this.categoriaComboBox.Location = new System.Drawing.Point(119, 281);
            this.categoriaComboBox.Name = "categoriaComboBox";
            this.categoriaComboBox.Size = new System.Drawing.Size(215, 21);
            this.categoriaComboBox.TabIndex = 18;
            // 
            // stockLabel
            // 
            stockLabel.AutoSize = true;
            stockLabel.Location = new System.Drawing.Point(340, 311);
            stockLabel.Name = "stockLabel";
            stockLabel.Size = new System.Drawing.Size(36, 13);
            stockLabel.TabIndex = 19;
            stockLabel.Text = "stock:";
            // 
            // stockNumericUpDown
            // 
            this.stockNumericUpDown.DataBindings.Add(new System.Windows.Forms.Binding("Value", this.peliculasBindingSource, "stock", true));
            this.stockNumericUpDown.Location = new System.Drawing.Point(382, 311);
            this.stockNumericUpDown.Name = "stockNumericUpDown";
            this.stockNumericUpDown.Size = new System.Drawing.Size(54, 20);
            this.stockNumericUpDown.TabIndex = 20;
            // 
            // BTNCaratula
            // 
            this.BTNCaratula.Location = new System.Drawing.Point(467, 399);
            this.BTNCaratula.Name = "BTNCaratula";
            this.BTNCaratula.Size = new System.Drawing.Size(121, 23);
            this.BTNCaratula.TabIndex = 21;
            this.BTNCaratula.Text = "Añadir caratula";
            this.BTNCaratula.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.BTNCaratula);
            this.Controls.Add(codpeliLabel);
            this.Controls.Add(this.codpeliLabel1);
            this.Controls.Add(tituloLabel);
            this.Controls.Add(this.tituloTextBox);
            this.Controls.Add(directorLabel);
            this.Controls.Add(this.directorTextBox);
            this.Controls.Add(protagonistaLabel);
            this.Controls.Add(this.protagonistaTextBox);
            this.Controls.Add(argumentoLabel);
            this.Controls.Add(this.argumentoTextBox);
            this.Controls.Add(estiloLabel);
            this.Controls.Add(this.estiloComboBox);
            this.Controls.Add(anioLabel);
            this.Controls.Add(this.anioLabel1);
            this.Controls.Add(caratulaLabel);
            this.Controls.Add(this.caratulaPictureBox);
            this.Controls.Add(categoriaLabel);
            this.Controls.Add(this.categoriaComboBox);
            this.Controls.Add(stockLabel);
            this.Controls.Add(this.stockNumericUpDown);
            this.Controls.Add(this.peliculasBindingNavigator);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.vcb)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.peliculasBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.peliculasBindingNavigator)).EndInit();
            this.peliculasBindingNavigator.ResumeLayout(false);
            this.peliculasBindingNavigator.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.caratulaPictureBox)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.stockNumericUpDown)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private vcb vcb;
        private System.Windows.Forms.BindingSource peliculasBindingSource;
        private vcbTableAdapters.peliculasTableAdapter peliculasTableAdapter;
        private vcbTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator peliculasBindingNavigator;
        private System.Windows.Forms.ToolStripButton bindingNavigatorAddNewItem;
        private System.Windows.Forms.ToolStripLabel bindingNavigatorCountItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorDeleteItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveFirstItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMovePreviousItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator;
        private System.Windows.Forms.ToolStripTextBox bindingNavigatorPositionItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator1;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveNextItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveLastItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator2;
        private System.Windows.Forms.ToolStripButton peliculasBindingNavigatorSaveItem;
        private System.Windows.Forms.Label codpeliLabel1;
        private System.Windows.Forms.TextBox tituloTextBox;
        private System.Windows.Forms.TextBox directorTextBox;
        private System.Windows.Forms.TextBox protagonistaTextBox;
        private System.Windows.Forms.TextBox argumentoTextBox;
        private System.Windows.Forms.ComboBox estiloComboBox;
        private System.Windows.Forms.Label anioLabel1;
        private System.Windows.Forms.PictureBox caratulaPictureBox;
        private System.Windows.Forms.ComboBox categoriaComboBox;
        private System.Windows.Forms.NumericUpDown stockNumericUpDown;
        private System.Windows.Forms.Button BTNCaratula;
    }
}

