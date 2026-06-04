package at.spengergasse.views.pricing;

import at.spengergasse.views.home.HomeView;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Pricing")
@Route("pricing")
@Menu(order = 1, icon = LineAwesomeIconUrl.FILE)
public class PricingView extends VerticalLayout {

    public PricingView() {
        setSpacing(false);
        setAlignItems(Alignment.CENTER);

        Image img = new Image("images/logo.png", "Bike Fast Logo");
        img.getStyle()
                .setWidth("220px");

        H2 title = new H2("Bike Category");

        VerticalLayout card1 = createCard("City Bike","for everyday rides in the city.", 8.0);
        VerticalLayout card2 = createCard("Trekking Bike","for longer trips and mixed roads.", 12.0);
        VerticalLayout card3 = createCard("Mountain Bike","for off-road trails and rough terrain.", 15.0);
        VerticalLayout card4 = createCard("E-Bike","for easier riding with electric support.", 25.0);

        FlexLayout cardsLayout = new FlexLayout(card1, card2, card3, card4);
        cardsLayout.setWidthFull();
        cardsLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        cardsLayout.setFlexWrap(FlexLayout.FlexWrap.WRAP);


        add(HomeView.getHeader(), img, title,cardsLayout);
    }

    private VerticalLayout createCard(String bikeCategory,String bikeDescription,Double bikeRentPrice){

        H2 category = new H2(bikeCategory);
        Paragraph description = new Paragraph(bikeDescription);
        Paragraph rentPrice = new Paragraph("from €" + bikeRentPrice + " / day");


        VerticalLayout card = new VerticalLayout(category,description,rentPrice);
        card.setWidth("350px");
        card.setPadding(true);
        card.setSpacing(false);

        card.getStyle()
                .set("border", "1px solid lightgray")
                .set("border-radius", "10px")
                .set("margin", "10px");

        return card;
    }

}
