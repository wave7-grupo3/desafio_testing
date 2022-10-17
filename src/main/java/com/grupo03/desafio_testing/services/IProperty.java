package com.grupo03.desafio_testing.services;

import com.grupo03.desafio_testing.advisor.NotFoundException;
import com.grupo03.desafio_testing.model.District;
import com.grupo03.desafio_testing.model.Property;
import com.grupo03.desafio_testing.model.Room;

import java.math.BigDecimal;
import java.util.List;

public interface IProperty {
    /**
     * Rota responsável pela criação de uma propriedade.
     * @author Grupo 03
     * @param property - Property
     * @return Property - Retorna uma entidade do tipo Property.
     * @throws NotFoundException
     */
    Property createProperty(Property property);

    /**
     * Método responsável por listar todas as propriedades.
     * @author Grupo 03
     * @return List<Property> - Retorna uma lista de Propriedades.
     */
    List<Property> getAll();

    /**
     * Método responsável por retornar o maior comodo de uma propriedade.
     * @author Grupo 03
     * @param id - String
     * @return Room - Retorna uma entidade do tipo Room.
     */
    Room getBiggestRoom(String id);

    /**
     * Método responsável por calcular o valor da área total do comodo.
     * @author Grupo 03
     * @param room - Room
     * @return Double - Retorna o valor do tipo Double referente a área total do comodo.
     */
    Double calculateTotalRoomArea(Room room);

    /**
     * Método responsável por calcular a área total da propriedade.
     * @author Grupo 03
     * @param property - Property
     * @return Double - Retorna o valor do tipo Double referente a área total da propriedade.
     */
    Double calculateTotalPropArea(Property property);

    /**
     * Método responsável por calcular o preço total de uma propriedade.
     * @author Grupo 03
     * @param property - Property
     * @return BigDecimal - Retorna o valor do tipo BigDecimal referente ao preço da propriedade.
     */
    BigDecimal calculateTotalPropPrice(Property property);

    /**
     * Método responsável por verificar se distrito está contido na base de dados.
     * @author Grupo 03
     * @param district - District
     * @return List<District> - Retorna um distrito, caso ele esteja contido no base de dados.
     */
    List<District> verifyDistrictExist(District district);

    /**
     * Método responsável por encontrar o maior comodo da lista de comodos.
     * @author Grupo 03
     * @param rooms - List<Room>
     * @return Room - Retorna o maior comodo da propriedade.
     */
    Room findBiggestRoom(List<Room> rooms);
}
