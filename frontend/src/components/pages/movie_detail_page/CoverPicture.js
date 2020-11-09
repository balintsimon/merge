import React from 'react';
import {API_URL_PICTURE} from "../../../Constants";
import {Link} from "react-router-dom";

const CoverPicture = (props) => {

  const scheduledPicture = (onSchedule) => {
    const scheduleGreenSource = "/images/schedule_green.png";
    const scheduleRedSource = "/images/schedule_red.png";

    const ScheduleStyle = {
      width: "75px",
      zIndex: "1",
      position: "absolute",
      marginTop: "2%",
      marginLeft: "-10.75%",
      border: "6px solid #2e2e2e",
      borderRadius: "35px"
    };

    if (onSchedule) {
      return <img style={ScheduleStyle} src={scheduleGreenSource} alt="This movie is on schedule! Book a seat!"/>
    }
    return <img style={ScheduleStyle} src={scheduleRedSource} alt="This movie isn't on schedule, but you can browse our programme."/>
  };

  if (props.backdrop === null) {
    /* IF NO Backdrop picture, return empty div with lower height. */
    return (
        <div className="col-md-12" style={{height: "125px", backgroundColor: "#2e2e2e", padding: "0"}}>
          <div style={{textAlign: "center", padding: "2%", backgroundColor: "#343434"}}>
          </div>
        </div>
    );
  }

  return (
      <div className="col-md-12" style={{height: "300px", backgroundColor: "#e6b31e", padding: "0"}}>
        <div style={{textAlign: "center", padding: "2%", backgroundColor: "#343434"}}>
          <img
              src={`${API_URL_PICTURE}${props.size}${props.backdrop}`}
              alt="Backdrop" style={{width: "100%"}}
          />
          <Link to="/schedule">
            {scheduledPicture(props.onSchedule)}
          </Link>
          }
        </div>
      </div>
  );
}

export default CoverPicture;