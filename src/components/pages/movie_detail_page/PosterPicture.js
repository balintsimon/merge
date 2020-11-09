import React from 'react';
import {API_URL_PICTURE} from "../../../Constants";

const PosterPicture = (props) => {

    let imageSource;

    if (props.poster === null) {
        imageSource = "/images/no_poster.png";
    } else {
        imageSource = `${API_URL_PICTURE}${props.imageSize}${props.poster}`
    }

    return (
        <div className="row no-gutters">
            <div className="col-md-12" style={{
                height: "250px",
                padding: "0",
                textAlign: "center",
                position: "relative",
            }}>
                <img
                    src={imageSource}
                    alt="Poster" style={{
                    height: "400px",
                    position: "absolute",
                    top: "-190px",
                    left: "90px",
                    zIndex: "1",
                    padding: "10px",
                    backgroundColor: "#343434",
                }}
                />
            </div>
        </div>
    );
}

export default PosterPicture;