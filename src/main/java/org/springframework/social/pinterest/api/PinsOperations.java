package org.springframework.social.pinterest.api;

public interface PinsOperations {

	Data<Pins> create(PinsData pinsData, String fields);

	Data<Pins> create(PinsData pinsData);

	void delete(String pin);

	Data<Pins> patch(String pin, PinsData pinsData, String fields);

	Data<Pins> patch(String pin, PinsData pinsData);

	Data<Pins> get(String pin, String fields);

	Data<Pins> get(String pin);
}
