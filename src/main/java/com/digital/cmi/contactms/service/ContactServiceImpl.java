package com.digital.cmi.contactms.service;

import com.digital.cmi.contactms.model.Contact;
import com.digital.cmi.contactms.model.RelatedPartyRef;
import com.digital.cmi.contactms.repository.ContactRepository;
import com.digital.cmi.contactms.repository.RelatedPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private RelatedPartyRepository relatedPartyRepository;

    @Override
    public Contact findContactById(String id) {

        Contact contact = null;
        Optional<Contact> contactOptional = contactRepository.findById(id);
        if(contactOptional.isPresent()){
            contact = contactOptional.get();
            Optional<RelatedPartyRef> relatedPartyRefOptional =
                    relatedPartyRepository.findById(contact.getRelatedParty().getId());
            if(relatedPartyRefOptional.isPresent()){
                contact.setRelatedParty(relatedPartyRefOptional.get());
            }
        }
        return contact;
    }

    @Override
    public RelatedPartyRef findRelatedPartyById(String id) {
        return relatedPartyRepository.findById(id).get();
    }
}
