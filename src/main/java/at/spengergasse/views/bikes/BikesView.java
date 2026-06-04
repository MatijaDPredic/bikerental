package at.spengergasse.views.bikes;

import at.spengergasse.views.home.HomeView;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Bikes")
@Route("bikes")
@Menu(order = 2, icon = LineAwesomeIconUrl.FILE)
public class BikesView extends VerticalLayout {

    public BikesView() {
        setSpacing(false);
        setAlignItems(Alignment.CENTER);

        Image img = new Image("images/logo.png", "Bike Fast Logo");
        img.getStyle()
                .setWidth("220px");

        add(HomeView.getHeader(),img);
    }

}
