package com.paypal.bfs.macros;

import com.paypal.bfs.entity.AddressEntity;
import com.paypal.bfs.test.employeeserv.api.model.Address;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-23T06:43:57-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
@Component
public class AddressToAddressEntityImpl implements AddressToAddressEntity {

    @Override
    public AddressEntity addressToAddressEntity(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setId( address.getId() );
        addressEntity.setLine1( address.getLine1() );
        addressEntity.setLine2( address.getLine2() );
        addressEntity.setCity( address.getCity() );
        addressEntity.setState( address.getState() );
        addressEntity.setCountry( address.getCountry() );
        addressEntity.setZipCode( address.getZipCode() );

        return addressEntity;
    }

    @Override
    public Address addressEntityToAddress(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressEntity.getId() );
        address.setLine1( addressEntity.getLine1() );
        address.setLine2( addressEntity.getLine2() );
        address.setCity( addressEntity.getCity() );
        address.setState( addressEntity.getState() );
        address.setCountry( addressEntity.getCountry() );
        address.setZipCode( addressEntity.getZipCode() );

        return address;
    }
}
