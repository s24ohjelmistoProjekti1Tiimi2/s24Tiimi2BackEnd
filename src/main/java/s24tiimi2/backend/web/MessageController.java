package s24tiimi2.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import s24tiimi2.backend.domain.CustomerRepository;
import s24tiimi2.backend.domain.DeleteMessageRepository;

@Controller
public class MessageController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private DeleteMessageRepository messageRepository;

}
