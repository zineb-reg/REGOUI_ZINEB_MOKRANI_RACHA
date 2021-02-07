package package1;


/**
 * Un objet IFormeAnimable est capable d'animer (de déplacer) une forme.
 * 
 */
public interface IFormeAnimable {
    
    /**
     * fait faire un déplacement élémentaire à une forme.
     *
     * @param forme la forme à déplacer
     */
    public void deplacer(IEtoilePolygone forme);

	
    
}
