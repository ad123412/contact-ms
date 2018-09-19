package com.digital.cmi.contactms.repository;

import com.digital.cmi.contactms.model.Contact;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends ElasticsearchRepository<Contact, String> {
}
