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
	private int idTechinian;
	private LocalDate startDate;
	private LocalDate deadlineDate;
	private String descriptionRepair;

}