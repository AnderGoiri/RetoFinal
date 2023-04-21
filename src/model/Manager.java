package model;

import java.util.Set;

/**
 * 
 * @author Ander
 * 
 *         Represents a user with additional management capabilities, such as
 *         the ability to validate other users' registration requests.
 *         <p>
 *         The <code>Manager</code> class extends the <code>User</code> class,
 *         inheriting all of its attributes and behaviors.
 *         </p>
 *         <p>
 *         In addition to the attributes inherited from the <code>User</code>
 *         class, the <code>Manager</code> class defines the following
 *         attributes:
 *         </p>
 *         <ul>
 *         <li><code>idSupervisor</code>: The ID of the manager's supervisor, if
 *         any.</li>
 *         <li><code>isTechnician</code>: A boolean indicating whether the
 *         manager is also a technician.</li>
 *         <li><code>isAdmin</code>: A boolean indicating whether the manager
 *         has administrative privileges.</li>
 *         <li><code>statusManager</code>: An enumeration representing the
 *         manager's current status.</li>
 *         <li><code>repairSet</code>: A set of all repairs currently assigned
 *         to the manager.</li>
 *         <li><code>managementSet</code>: A set of all management tasks
 *         currently assigned to the manager.</li>
 *         </ul>
 *
 */
public class Manager extends User {

	private static final long serialVersionUID = 1L;

	// ---Attributes---
	private int idSupervisor;
	private boolean isTechnician;
	private boolean isAdmin;
	private EnumStatusManager statusManager;
	private Set<Repair> repairSet;
	private Set<Management> managementSet;

}
