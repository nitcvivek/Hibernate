An orphaned record is, is a record whose foreign key value references a nonexistent primary key value.

JPA 2 supports an additional and more aggressive remove cascading mode which can be specified using the orphanRemoval element of the @OneToOne and @OneToMany annotations


Hibernate orphanRemoval vs. CascadeType.REMOVE

If the orphanRemoval mechanism allows us to trigger a remove operation on the disassociated child entity, 
The CascadeType.REMOVE strategy propagates the remove operation from the parent to all the child entities.

Don’t use CascadeType.REMOVE with @ManyToMany associations

The CascadeType.REMOVE strategy is useful for the @OneToMany and @OneToOne associations only. If you are using a @ManyToMany association, you should never set the CascadeType.ALL attribute value, as you’ll also inherit the CascadeType.REMOVE strategy.

Cascading makes sense from a parent entity to a child. Because a collection annotated with @ManyToMany associates two parent entities via a join table, we don’t want to propagate the remove from one parent to another. Instead, we want to propagate the remove operation from the parent to the join table child records.

When removing an element from the @ManyToMany collection, Hibernate generates a DELETE statement for the join table record. So, it works like orphanRemoval, but instead of propagating the remove to the actual entity that is removed from the collection, it triggers the DELETE statement for the child row in the join table.
