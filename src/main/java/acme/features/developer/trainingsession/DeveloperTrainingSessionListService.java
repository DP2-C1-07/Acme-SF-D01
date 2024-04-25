
package acme.features.developer.trainingsession;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.client.data.models.Dataset;
import acme.client.services.AbstractService;
import acme.entities.trainingmodules.TrainingModule;
import acme.entities.trainingsessions.TrainingSession;
import acme.roles.Developer;

@Service
public class DeveloperTrainingSessionListService extends AbstractService<Developer, TrainingSession> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private DeveloperTrainingSessionRepository repository;

	// AbstractService interface ----------------------------------------------


	@Override
	public void authorise() {
		boolean status;
		int masterId;
		TrainingModule trainingModule;

		masterId = super.getRequest().getData("masterId", int.class);
		trainingModule = this.repository.findOneTrainingModuleById(masterId);
		status = trainingModule != null && (!trainingModule.isDraft() || super.getRequest().getPrincipal().hasRole(trainingModule.getDeveloper()));

		super.getResponse().setAuthorised(status);
	}

	@Override
	public void load() {
		Collection<TrainingSession> objects;
		int masterId;

		masterId = super.getRequest().getData("masterId", int.class);
		objects = this.repository.findManyTrainingSessionsByMasterId(masterId);

		super.getBuffer().addData(objects);
	}

	@Override
	public void unbind(final TrainingSession object) {
		assert object != null;

		Dataset dataset;

		dataset = super.unbind(object, "code", "initiateMoment", "finalizationMoment", "location", "instructor", "contactEmail", "link", "trainingModule", "draft");

		super.getResponse().addData(dataset);
	}

	@Override
	public void unbind(final Collection<TrainingSession> objects) {
		assert objects != null;

		int masterId;
		TrainingModule trainingModule;
		final boolean showCreate;

		masterId = super.getRequest().getData("masterId", int.class);
		trainingModule = this.repository.findOneTrainingModuleById(masterId);
		showCreate = trainingModule.isDraft() && super.getRequest().getPrincipal().hasRole(trainingModule.getDeveloper());

		super.getResponse().addGlobal("masterId", masterId);
		super.getResponse().addGlobal("showCreate", showCreate);
	}

}