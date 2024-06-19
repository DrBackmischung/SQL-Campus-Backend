package de.sqlcampus.backend.misc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import de.sqlcampus.backend.h2.entities.Brand;
import de.sqlcampus.backend.h2.entities.Item;
import de.sqlcampus.backend.h2.entities.Supermarket;
import de.sqlcampus.backend.h2.repo.BrandRepository;
import de.sqlcampus.backend.h2.repo.CustomerRepository;
import de.sqlcampus.backend.h2.repo.EmployeeRepository;
import de.sqlcampus.backend.h2.repo.ItemRepository;
import de.sqlcampus.backend.h2.repo.OrderRepository;
import de.sqlcampus.backend.h2.repo.SupermarketRepository;

@Component
public class StartupListener {
	
	@Autowired
	SupermarketRepository supermarketRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	BrandRepository brandRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {

    	Supermarket s001 = new Supermarket("S001", "LowCost Heidelberg-Bahnstadt", "Europaplatz 1", "Heidelberg", "69115", "06221-90344113", "heidelberg-bahnstadt@lowcost.com");
    	Supermarket s002 = new Supermarket("S002", "LowCost Heidelberg-Altstadt", "Plöck 20", "Heidelberg", "69117", "06221-90344201", "heidelberg-altstadt@lowcost.com");
    	Supermarket s003 = new Supermarket("S003", "LowCost Mosbach", "Hauptstraße 12", "Mosbach", "74821", "06261-1234567890", "mosbach@lowcost.com");

    	Brand b001 = new Brand("B001", "NoBrand", "", "", "", "", "", "", "", "", "");
    	Brand b002 = new Brand("B002", "LowCost Premium", "Addresse", "Stadt", "PLZ", "Phone", "Email", "URL", "ContactName", "ContactPhone", "ContactMail");
    	Brand b003 = new Brand("B003", "LowCost", "Addresse", "Stadt", "PLZ", "Phone", "Email", "URL", "ContactName", "ContactPhone", "ContactMail");
    	Brand b004 = new Brand("B004", "LowCost 4 Nature", "Addresse", "Stadt", "PLZ", "Phone", "Email", "URL", "ContactName", "ContactPhone", "ContactMail");
    	Brand b005 = new Brand("B005", "Coca Cola", "Addresse", "Stadt", "PLZ", "Phone", "Email", "URL", "ContactName", "ContactPhone", "ContactMail");
    	Brand b006 = new Brand("B006", "Pepsico", "Addresse", "Stadt", "PLZ", "Phone", "Email", "URL", "ContactName", "ContactPhone", "ContactMail");
    	Brand b007 = new Brand("B007", "Wagner", "Addresse", "Stadt", "PLZ", "Phone", "Email", "URL", "ContactName", "ContactPhone", "ContactMail");
    	Brand b008 = new Brand("B008", "Dr. Oetker", "Addresse", "Stadt", "PLZ", "Phone", "Email", "URL", "ContactName", "ContactPhone", "ContactMail");
    	Brand b009 = new Brand("B009", "Mars", "Addresse", "Stadt", "PLZ", "Phone", "Email", "URL", "ContactName", "ContactPhone", "ContactMail");
    	Brand b010 = new Brand("B010", "RedBull", "Addresse", "Stadt", "PLZ", "Phone", "Email", "URL", "ContactName", "ContactPhone", "ContactMail");
    	Brand b011 = new Brand("B011", "Monster", "Addresse", "Stadt", "PLZ", "Phone", "Email", "URL", "ContactName", "ContactPhone", "ContactMail");

    	Item i001 = new Item("I001", "Banana", "Single Banana", 0.5, b001, 19, 0.3);
    	Item i002 = new Item("I001", "Banana", "Cheap Banana", 0.4, b003, 19, 0.3);
    	Item i003 = new Item("I001", "Banana", "BIO Banana", 0.4, b004, 19, 0.3);
    	
    }

}
