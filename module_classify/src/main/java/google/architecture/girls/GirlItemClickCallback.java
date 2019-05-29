
package google.architecture.girls;


import com.jzhson.communal.http.entities.GirlsData;

public interface GirlItemClickCallback {
    void onClick(GirlsData.ResultsBean girlsItem);
}
