package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Sweter;
import com.example.jsfdemo.service.SweterManager;

@SessionScoped//korzystanie z technologi CDI, znaczy ze bean bedzie umieszczony w kontekscie sesji, i jest zapewniony przez kontener czas zycia
@Named("sweterBean")//
public class SweterFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Sweter sweter = new Sweter();

	private ListDataModel<Sweter> sweters = new ListDataModel<Sweter>();

	@Inject//wstrzykniecie z sweterBean
	private SweterManager sm;

	public Sweter getSweter() {
		return sweter;
	}

	public void setSweter(Sweter sweter) {
		this.sweter = sweter;
	}

	public ListDataModel<Sweter> getAllSweters() {
		sweters.setWrappedData(sm.getAllSweters());
		return sweters;
	}

	// Actions
	public String addSweter() {
		sm.addSweter(sweter);
		return "showSweters";
		//return null;
	}

	public String deleteSweter() {
		Sweter sweterToDelete = sweters.getRowData();
		sm.deleteSweter(sweterToDelete);
		return null;
	}

	// Validators

	// Business logic validation
	public void uniqueName(FacesContext context, UIComponent component,
			Object value) {

		String name = (String) value;
		
		for (Sweter sweter : sm.getAllSweters()) {
			if (sweter.getName().equalsIgnoreCase(name)) {
				FacesMessage message = new FacesMessage("Sweter with this name already exists in database");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
		/*for (Person person : pm.getAllPersons()) {
			if (person.getPin().equalsIgnoreCase(pin)) {
				FacesMessage message = new FacesMessage(
						"Person with this PIN already exists in database");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}*/
	}

	// Multi field validation with <f:event>
	// Rule: first two digits of PIN must match last two digits of the year of
	// birth
	public void validatePinDob(ComponentSystemEvent event) {

		UIForm form = (UIForm) event.getComponent();
		UIInput pin = (UIInput) form.findComponent("zip");
		UIInput dob = (UIInput) form.findComponent("zip");

		if (pin.getValue() != null && dob.getValue() != null
				&& pin.getValue().toString().length() >= 2) {
			String twoDigitsOfPin = pin.getValue().toString().substring(0, 2);
			Calendar cal = Calendar.getInstance();
			cal.setTime(((Date) dob.getValue()));

			String lastDigitsOfDob = ((Integer) cal.get(Calendar.YEAR))
					.toString().substring(2);

			if (!twoDigitsOfPin.equals(lastDigitsOfDob)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(form.getClientId(), new FacesMessage(
						"PIN doesn't match date of birth"));
				context.renderResponse();
			}
		}
	}
}
