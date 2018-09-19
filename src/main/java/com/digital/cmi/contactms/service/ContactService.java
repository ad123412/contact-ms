package com.digital.cmi.contactms.service;

import com.digital.cmi.contactms.model.Contact;
import com.digital.cmi.contactms.model.RelatedPartyRef;

public interface ContactService {

    public Contact findContactById(String id);

    public RelatedPartyRef findRelatedPartyById(String id);
}
