package dev.well.bms.ddd;

public interface DomainEntity <ID extends DomainId> {

    public ID identity();

    public boolean sameAs(Object object);
}
