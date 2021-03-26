package ua.khpi.oop.zanochkyn16.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Helper class to wrap a list of clients. This is used for saving the
 * list of persons to XML.
 */
@XmlRootElement(name = "clients")
public class ClientListWrapper
{
	private List<Client> clients;

	@XmlElement(name = "client")
	public List<Client> getClients()
	{
		return clients;
	}

	public void setClients(List<Client> clients)
	{
		this.clients = clients;
	}
}