package at.spengergasse.views.pricing;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
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
        H1 companyName = new H1("Bike Fast");
        companyName.getStyle()
                .set("font-family", "cursive")
                .set("font-size", "6rem")
                .set("margin", "0");

        H2 subName = new H2("... need a ride get it fast at ...");
        subName.getStyle()
                .set("margin", "0")
                .set("color", "gray");

        Image img = new Image("images/logo.png", "Bike Fast Logo");
        img.setWidth("220px");

        H2 title = new H2("Bike Category");

        H2 zone1 = new H2("City Bike");
        Paragraph price1 = new Paragraph("for everyday rides in the city.");
        Paragraph free1 = new Paragraph("from €8 / day");

        H2 zone2 = new H2("Trekking Bike");
        Paragraph price2 = new Paragraph("for longer trips and mixed roads.");
        Paragraph free2 = new Paragraph("from €12 / day");

        H2 zone3 = new H2("Mountain Bike");
        Paragraph price3 = new Paragraph("for off-road trails and rough terrain.");
        Paragraph free3 = new Paragraph("from €15 / day");

        H2 zone4 = new H2("E-Bike");
        Paragraph price4 = new Paragraph("for easier riding with electric support.");
        Paragraph free4 = new Paragraph("from €25 / day");

        add(
                companyName, subName, img, title,
                zone1, price1, free1,
                zone2, price2, free2,
                zone3, price3, free3,
                zone4, price4, free4
        );
    }

}
