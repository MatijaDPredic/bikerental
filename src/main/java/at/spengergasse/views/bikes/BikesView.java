package at.spengergasse.views.bikes;

import at.spengergasse.domain.RentedBike;
import at.spengergasse.service.RentedBikeService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Bikes")
@Route("bikes")
@Menu(order = 2, icon = LineAwesomeIconUrl.FILE)
public class BikesView extends VerticalLayout {
    private final Grid<RentedBike> grid = new Grid<>(RentedBike.class,true);
    private final RentedBikeService rentedBikeService;

    public BikesView(@Autowired RentedBikeService rentedBikeService) {
        this.rentedBikeService = rentedBikeService;

        setSpacing(true);
        setSizeFull();
        grid.setSizeFull();
        add(grid);
        reload();
    }

    private void reload() {
        grid.setItems(rentedBikeService.findAll());
    }


}
