package at.spengergasse.views.home;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.jspecify.annotations.NonNull;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Home")
@Route("")
@Menu(order = 0, icon = LineAwesomeIconUrl.GLOBE_SOLID)
public class HomeView extends VerticalLayout {

    public HomeView() {
        setSpacing(false);
        setAlignItems(Alignment.CENTER);

        HorizontalLayout logoText = new HorizontalLayout();

        logoText.setWidthFull();
        logoText.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        Div left = new Div();
        Div center = new Div();
        Div right = new Div();

        left.setWidth("33%");
        center.setWidth("34%");
        right.setWidth("33%");

        logoText.add(left, center, right);

        Image img = new Image("images/logo.png", "Bike Fast Logo");
        img.getStyle()
                .setHeight("220px");

        left.add(img);

        Paragraph description = getDescription();
        description.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "center")
                .set("white-space", "pre-line");//This line makes a white space appear were a new line is

        center.add(description);

        H3 name = new H3("Bike Fast GmbH");
        H3 street = new H3("Spengergasse 20");
        H3 city = new H3("1050 Wien");

        add(getHeader(), logoText, name, street, city);

    }

    private static @NonNull Paragraph getDescription() {
        Paragraph description = new Paragraph(
                """
                        Bike Fast is the company that saves your day when your feet are slow but your plans are not.
                         We make getting a ride quick, easy, and a little more fun — because nobody likes waiting\
                         when there’s somewhere to be.
                        
                         With "need a ride get it fast at", Bike Fast \
                        keeps you moving without the drama, the delay, or the excuses.\
                        It’s simple: hop on, ride off, and get there faster than you can say\
                         “Where’s my bike?” \
                        
                        
                        Whether it’s school, the city, or just a last-minute mission,\
                         Bike Fast is the fast lane for people who do not have time to waste."""
        );
        description.setWidth("500px");
        return description;
    }

    public static Component getHeader(){

        H1 companyName = new H1("Bike Fast");
        companyName.getStyle()
                .set("font-family", "cursive")
                .set("font-size", "6rem")
                .set("margin", "0");

        H2 subName = new H2("... need a ride get it fast at ...");
        subName.getStyle()
                .set("margin", "0")
                .set("color", "gray");


        VerticalLayout headerLayout = new VerticalLayout(companyName, subName);
        headerLayout.setSpacing(false);
        headerLayout.setPadding(false);
        headerLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        return headerLayout;
    }

}
