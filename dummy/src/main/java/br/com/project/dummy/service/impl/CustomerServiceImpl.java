package br.com.project.dummy.service.impl;

import br.com.project.dummy.entity.CustomerEntity;
import br.com.project.dummy.handler.EntityNotFoundException;
import br.com.project.dummy.handler.ExistingEntityException;
import br.com.project.dummy.model.Customer;
import br.com.project.dummy.repository.CustomerRepository;
import br.com.project.dummy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        List<CustomerEntity> customerEntityList = new ArrayList<>();
        customerEntityList = customerRepository.findAll();

        List<Customer> customerList = new ArrayList<>();
        customerEntityList.forEach(entity -> {
            Customer dto = convertEntityToDto(entity);
            customerList.add(dto);
        });

        return customerList;
    }

    @Override
    public Customer getByCustomerId(Long id) {
        CustomerEntity customerDB = verifyCustomer(id);
        return convertEntityToDto(customerDB);
    }

    @Override
    public Customer create(Customer customerRequest) {
        if (customerRequest.getId() != null) {
            throw new ExistingEntityException(EntityNotFoundException.EntityType.CUSTOMER);
        }
        CustomerEntity customerDB = convertDtoToEntity(customerRequest);
        customerDB = customerRepository.save(customerDB);
        return convertEntityToDto(customerDB);
    }

    @Override
    public Customer update(Long id, Customer customerRequest) {
        CustomerEntity entity = verifyCustomer(id);

        entity.setName(customerRequest.getName());
        entity.setLastName(customerRequest.getLastName());
        entity.setEmail(customerRequest.getEmail());
        entity.setMobilePhone(customerRequest.getMobilePhone());

        entity = customerRepository.save(entity);
        return convertEntityToDto(entity);
    }

    @Override
    public void delete(Long id) {
        CustomerEntity customerDB = verifyCustomer(id);
        customerRepository.delete(customerDB);
    }

    private CustomerEntity verifyCustomer(Long id) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty()) {
            throw new EntityNotFoundException(EntityNotFoundException.EntityType.CUSTOMER);
        }

        return optionalCustomer.get();
    }

    private CustomerEntity convertDtoToEntity(Customer dto) {
        CustomerEntity result = new CustomerEntity();
        if (dto.getId() != null) {
            result.setId(dto.getId());
        }
        result.setName(dto.getName());
        result.setLastName(dto.getLastName());
        result.setEmail(dto.getEmail());
        result.setMobilePhone(dto.getMobilePhone());

        return result;
    }

    private Customer convertEntityToDto(CustomerEntity entity) {
        Customer result = new Customer();
        result.setId(entity.getId());
        result.setName(entity.getName());
        result.setLastName(entity.getLastName());
        result.setEmail(entity.getEmail());
        result.setMobilePhone(entity.getMobilePhone());

        return result;
    }
}
