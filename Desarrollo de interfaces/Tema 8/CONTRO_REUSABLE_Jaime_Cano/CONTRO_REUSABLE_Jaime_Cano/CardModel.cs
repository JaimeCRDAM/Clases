using PropertyChanged;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CONTRO_REUSABLE_Jaime_Cano
{
    [AddINotifyPropertyChangedInterface]
    public class CardModel
    {
        public string StudyCenter { get; set; }
        public string AlumnName { get; set; }
        public string BornDate { get; set; }
        public string ImgSource { get; set; }
    }
}
