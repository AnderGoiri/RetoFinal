package model;

import java.time.LocalDate;

/**
 * @author Ander
 * 
 *         The <code>Repair</code> class represents a repair task assigned to a
 *         technician in the system. It contains information such as the ID of
 *         the repair task, the cost of the repair, the current status of the
 *         repair, the ID of the technician assigned to the task, the start date
 *         and deadline date of the repair, and a description of the repair
 *         needed.
 */
public class Repair {

	// ---Attributes---
	private int idRepair;
	private float repairCost;
	private EnumStatusRepair statusRepair;
	private int idTechnician;
	private LocalDate startDate;
	private LocalDate deadlineDate;
	private String descriptionRepair;

	// --- Getters & Setters ---
	public int getIdRepair() {
		return idRepair;
	}

	public void setIdRepair(int idRepair) {
		this.idRepair = idRepair;
	}

	public float getRepairCost() {
		return repairCost;
	}

	public void setRepairCost(float repairCost) {
		this.repairCost = repairCost;
	}

	public EnumStatusRepair getStatusRepair() {
		return statusRepair;
	}

	public void setStatusRepair(EnumStatusRepair statusRepair) {
		this.statusRepair = statusRepair;
	}

	public int getIdTechnician() {
		return idTechnician;
	}

	public void setIdTechnician(int idTechnician) {
		this.idTechnician = idTechnician;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(LocalDate deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public String getDescriptionRepair() {
		return descriptionRepair;
	}

	public void setDescriptionRepair(String descriptionRepair) {
		this.descriptionRepair = descriptionRepair;
	}

	// --- Constructors ---
	public Repair(int idRepair, float repairCost, EnumStatusRepair statusRepair, int idTechnician, LocalDate startDate,
			LocalDate deadlineDate, String descriptionRepair) {
		super();
		this.idRepair = idRepair;
		this.repairCost = repairCost;
		this.statusRepair = statusRepair;
		this.idTechnician = idTechnician;
		this.startDate = startDate;
		this.deadlineDate = deadlineDate;
		this.descriptionRepair = descriptionRepair;
	}

	public Repair() {
		super();
	}

}