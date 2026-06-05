package at.spengergasse.views.bikes;

import at.spengergasse.domain.RentedBike;
import at.spengergasse.domain.RentedBikeException;
import at.spengergasse.service.RentedBikeService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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
    private final Grid<RentedBike> grid = new Grid<>(RentedBike.class, true);
    private final RentedBikeService rentedBikeService;

    Button buttonRemoveAllRenters = new Button("Remove all");
    Button buttonAdd10Renters = new Button("Add 10 Renters");
    Button buttonAdd1ToPrice = new Button("Add 1 to price");
    Button buttonRemoveLoyalCostumers = new Button("Remove Loyal Costumers");
    Button buttonAddWrong = new Button("Add Wrong!?!");

    public BikesView(@Autowired RentedBikeService rentedBikeService) {
        this.rentedBikeService = rentedBikeService;

        setSpacing(true);
        setSizeFull();


        buttonRemoveAllRenters.addClickListener(_ -> removeAllRenters());
        buttonAdd10Renters.addClickListener(_ -> add10Renters());
        buttonAdd1ToPrice.addClickListener(_ -> add1ToPrice());
        buttonRemoveLoyalCostumers.addClickListener(_ -> removeLoyalCostumers());
        buttonAddWrong.addClickListener(_ -> addWrong());

        add(new HorizontalLayout(
                buttonRemoveAllRenters,
                buttonAdd10Renters,
                buttonAdd1ToPrice,
                buttonRemoveLoyalCostumers,
                buttonAddWrong
        ));

        grid.setSizeFull();
        add(grid);
        reload();
    }

    private void addWrong() {
        try {
            rentedBikeService.addWrong();
            reload();
        } catch (RentedBikeException e) {
            ConfirmDialog dialog = new ConfirmDialog();
            dialog.setHeader("Error");
            dialog.setText(e.getMessage());
            dialog.setConfirmText("OK");
            dialog.open();
            reload();
        }

    }

    private void removeLoyalCostumers() {
        try {
            rentedBikeService.removeLoyalCostumers();
            if (rentedBikeService.getRentedBikes().isEmpty()) {
                buttonRemoveAllRenters.setEnabled(false);
                buttonAdd1ToPrice.setEnabled(false);
                buttonRemoveLoyalCostumers.setEnabled(false);
            }
            reload();
        } catch (RentedBikeException e) {
            Notification.show(e.getMessage());
            reload();
        }
    }

    private void add1ToPrice() {
        try {
            rentedBikeService.add1ToPrice();
            reload();
        } catch (RentedBikeException e) {
            Notification.show(e.getMessage());
            reload();
        }
    }

    private void add10Renters() {
        try {
            rentedBikeService.add10Renters();

            buttonRemoveAllRenters.setEnabled(true);
            buttonAdd1ToPrice.setEnabled(true);
            buttonRemoveLoyalCostumers.setEnabled(true);

            reload();
        } catch (RentedBikeException e) {
            Notification.show(e.getMessage());
            reload();
        }
    }

    private void removeAllRenters() {
        try {
            rentedBikeService.removeAllRenters();

            buttonRemoveAllRenters.setEnabled(false);
            buttonAdd1ToPrice.setEnabled(false);
            buttonRemoveLoyalCostumers.setEnabled(false);

            reload();
        } catch (RentedBikeException e) {
            Notification.show(e.getMessage());
            reload();
        }
    }

    private void reload() {
        grid.setItems(rentedBikeService.findAll());
    }


}
