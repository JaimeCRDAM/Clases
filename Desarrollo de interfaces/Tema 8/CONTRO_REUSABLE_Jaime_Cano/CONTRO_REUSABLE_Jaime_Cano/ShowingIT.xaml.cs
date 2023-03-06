using Microsoft.Maui.Controls;
using PropertyChanged;
using System.Collections.ObjectModel;

namespace CONTRO_REUSABLE_Jaime_Cano;

[AddINotifyPropertyChangedInterface]
public partial class ShowingIT : ContentPage
{
	public ObservableCollection<CardModel> personalCards;
    public CardModel cardModel;
	public ShowingIT()
	{
        personalCards = new ObservableCollection<CardModel>
        {
            new CardModel()
            {
                StudyCenter = "Jaime",
                AlumnName = "Cano",
                BornDate = "https://avatars.githubusercontent.com/u/10767146?v=4",
                ImgSource = "https://avatars.githubusercontent.com/u/10767146?v=4"
            },
            new CardModel()
            {
                StudyCenter = "Jaime",
                AlumnName = "Cano",
                BornDate = "https://avatars.githubusercontent.com/u/10767146?v=4",
                ImgSource = "https://avatars.githubusercontent.com/u/10767146?v=4"
            },
            new CardModel()
            {
                StudyCenter = "Jaime",
                AlumnName = "Cano",
                BornDate = "https://avatars.githubusercontent.com/u/10767146?v=4",
                ImgSource = "https://avatars.githubusercontent.com/u/10767146?v=4"
            }
        };
        cardModel = personalCards[0];
        InitializeComponent();
		BindingContext = this;
	}
}